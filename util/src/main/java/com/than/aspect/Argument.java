package com.than.aspect;

import lombok.Data;

/**
 * @author Than
 * @package: com.than.aspect
 * @className: Arguments
 * @description: aop的通用参数类
 * @date: 2023/10/19 19:53
 */
@Data
public class Argument{

    private Object arg;

    private String argName;

    private Object extraArg;

    private String extraArgName;

    private String msg;


    public void setArgName(String argName) {
        this.argName = argName;
    }

    public Argument(Object arg) {
        this.arg = arg;
    }

    public Argument(Object arg, String argsName) {
        this.arg = arg;
        this.argName = argsName;
    }

    public Argument(Object arg, String argName, Object extraArg) {
        this.arg = arg;
        this.argName = argName;
        this.extraArg = extraArg;
    }

    public Argument() {

    }
}
