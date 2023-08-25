package com.than.config;

import com.than.base.Code;
import com.than.base.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Than
 * @package: com.than.config
 * @className: GlobalException
 * @description: 全局异常捕获, 统一处理
 * @date: 2023/8/25 20:56
 */
@RestControllerAdvice
public class GlobalException {


    /**
     * <p>其他所有的异常处理器,统一返回,发送邮件至管理员</p>
     * @return 固定结果, 因为暂时无法处理异常
     */
    @ExceptionHandler(value = { java.lang.Exception.class })

    public Result handleAllOthersException(Exception e){
        return new Result(Code.ERROR,"服务器繁忙!!");
    }

}
