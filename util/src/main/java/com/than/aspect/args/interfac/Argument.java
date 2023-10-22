package com.than.aspect.args.interfac;

/**
 * @author Than
 * @package: com.than.aspect.args.interfac
 * @className: Argument
 * @description: 参数类型, 此接口用来标记,代表一个需要aop注入的参数，使用时需要设置为变长参数，aop会自动注入一个参数进入
 * @date: 2023/10/20 23:53
 */
public interface Argument<T> {

    void setArg(T arg);
    T getArg();

}
