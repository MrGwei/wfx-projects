package com.wfx.projects.springcloud.feignservice.pojo;

import lombok.Data;

/**
 * @author Gwei
 */
@Data
public class Result<T> {
    private T data;

    private String message;

    private int code;

    public Result() {
    }

    public Result(T data, String message, int code) {
        this.data = data;
        this.message = message;
        this.code = code;
    }

    public Result(String message, Integer code) {
        this(null, message, code);
    }

    public Result(T data) {
        this(data, "操作成功", 200);
    }

}
