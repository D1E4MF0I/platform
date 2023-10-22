package com.than.aspect.factory;

import com.than.aspect.args.interfac.Argument;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/**
 * @author Than
 * @package: com.than.aspect.factory
 * @className: ArgsFactory
 * @description: 参数类型的工厂，参数类型不支持new，防止手动注入
 * @date: 2023/10/21 14:00
 */
public class ArgsFactory {

    private static final Map<String, Constructor<?>> map=new ConcurrentHashMap<>();
    private static final String NAME_PRE  = "com.than.aspect.args.";

    public static <T> Argument<T> create(String name){
        String temp=NAME_PRE+name;

        Constructor<?> constructor = map.computeIfAbsent(temp, s -> {
            try {
               return Class.forName(s).getDeclaredConstructor();
            } catch (NoSuchMethodException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });

        try {
            constructor.setAccessible(true);
            return (Argument<T>) constructor.newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }


}
