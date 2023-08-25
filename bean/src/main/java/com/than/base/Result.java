package com.than.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Result {

    private int code;

    private Object msg;

    @JsonIgnore
    private Object extraInformation;

    public Result() {
    }

    public Result(int code, Object msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(int code, Object msg, Object extraInformation) {
        this.code = code;
        this.msg = msg;
        this.extraInformation = extraInformation;
    }
}
