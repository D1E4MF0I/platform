package com.than.base;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.beans.JavaBean;

@Getter
@Setter
public class Result {

    private int code;
    private Object msg;

    public Result() {
    }

    public Result(int code, Object msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg=" + msg +
                '}';
    }

}
