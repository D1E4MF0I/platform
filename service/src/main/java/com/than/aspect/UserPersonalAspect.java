package com.than.aspect;

import com.than.aspect.args.ArgumentWithTow;
import com.than.aspect.args.AutoTokenArgument;
import com.than.aspect.args.interfac.Argument;
import com.than.aspect.factory.ArgsFactory;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author Than
 * @package: com.than.aspect
 * @className: UserManageAspect
 * @description: 用户管理接口service
 * @date: 2023/10/19 19:24
 */
@Aspect
@Component
@Slf4j
public class UserPersonalAspect {

    @Pointcut("@annotation(com.than.aspect.AutoToken)")
    public void cutPoint(){}

    @Around("cutPoint()")
    public Object autoTokenAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] args = proceedingJoinPoint.getArgs();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();
        String token = request.getHeader("token");
        Argument<String> argument=null;
        for (int i = 0; i < args.length; i++) {
            if(args[i] instanceof Argument<?>[]){
                argument = ArgsFactory.create("AutoTokenArgument");
                argument.setArg(token);

                AutoTokenArgument[] arguments={(AutoTokenArgument)argument};

                args[i]=arguments;
            }
        }
        if(argument==null){
            throw new RuntimeException();
        }
        return proceedingJoinPoint.proceed(args);
    }

}