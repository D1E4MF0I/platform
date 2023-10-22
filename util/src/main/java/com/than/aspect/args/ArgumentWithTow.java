package com.than.aspect.args;

import com.than.aspect.args.interfac.Argument;
import lombok.Data;

/**
 * @author Than
 * @package: com.than.aspect
 * @className: Arguments
 * @description: aop的通用参数类
 * @date: 2023/10/19 19:53
 */

@Data
public class ArgumentWithTow<T> implements Argument<T> {

    private T arg;

    private String argName;

    private Object extraArg;

    private String extraArgName;

    private String msg;



    private ArgumentWithTow() {

    }
    @Override
    public void setArg(T arg) {
        this.arg=arg;
    }

    @Override
    public T getArg() {
        return this.arg;
    }
}
