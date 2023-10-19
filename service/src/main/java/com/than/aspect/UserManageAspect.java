package com.than.aspect;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
public class UserManageAspect {

    private final ThreadLocal<HttpServletRequest> requestHolder = new ThreadLocal<>();


    @Pointcut("(execution(* com.than.service.user.UserManageService.*(..))) && (!execution(* com.than.service.user.UserManageService.*(com.than.dao.bean.UserBean)))")
    public void cutPoint(){}


    @Around("cutPoint()")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] args = proceedingJoinPoint.getArgs();

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();
        // 将请求对象存储在ThreadLocal中
        requestHolder.set(request);

        String headerValue = request.getHeader("token");

        Argument arg = (Argument) args[0];
        arg.setExtraArg(headerValue);



        return proceedingJoinPoint.proceed(args);
    }


    @AfterReturning("cutPoint()")
    public void afterCompletion(){
        requestHolder.remove();
    }


}
