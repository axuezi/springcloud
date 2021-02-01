package com.vmei.eurekaclient.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 返回数据体类
 *
 * @author axue
 */
@Data
public class Result<T> implements Serializable {

    private Integer code;

    private String message;

    private T data;

    public Result(ResultCode resultCode, T data) {
        this.code = resultCode.code();
        this.message = resultCode.message();
        this.data = data;
    }

    public static <T> Result<T> success() {
        return new Result<>(ResultCode.SUCCESS, null);
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(ResultCode.SUCCESS, data);
    }

    public static <T> Result<T> success(ResultCode resultCode, T data) {
        return new Result<>(resultCode, data);
    }

    public static <T> Result<T> failure(ResultCode resultCode) {
        return new Result<>(resultCode, null);
    }

    public static <T> Result<T> failure(ResultCode resultCode, T data) {
        return new Result<>(resultCode, data);
    }

}
