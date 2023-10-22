package com.than.aspect.args;

import com.than.aspect.args.interfac.Argument;

/**
 * @author Than
 * @package: com.than.aspect
 * @className: ArgumentWithOne
 * @description: aop通用参数，但只携带一个参数(泛型)
 * @date: 2023/10/20 23:52
 */
public class AutoTokenArgument implements Argument<String> {

    private String arg;


    private AutoTokenArgument() {}

    @Override
    public void setArg(String arg) {
        this.arg=arg;
    }

    @Override
    public String getArg() {
        return this.arg;
    }
}