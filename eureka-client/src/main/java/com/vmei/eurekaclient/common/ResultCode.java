package com.vmei.eurekaclient.common;

/**
 * 返回状态码
 *
 * @author axue
 */
public enum ResultCode {

    /**
     * 请求成功
     */
    SUCCESS(1, "请求成功");

    private final Integer code;

    private final String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }
}
