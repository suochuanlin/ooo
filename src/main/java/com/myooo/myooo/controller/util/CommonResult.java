package com.myooo.myooo.controller.util;

import lombok.Data;

@Data
public class CommonResult<T> {

    private int code;

    private String message;

    private T data;

    public CommonResult() {
    }

    public CommonResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int code() {
        return code;
    }

    public String message() {
        return message;
    }

    public T data() {
        return data;
    }

    private static <K> CommonResult<K> make(int code, String message, K data) {
        CommonResult<K> r = new CommonResult<>();
        r.code = code;
        r.message = message;
        r.data = data;
        return r;
    }

    public static <K> CommonResult<K> success(K data) {
        return make(0, "成功", data);
    }

    public static <K> CommonResult<K> success(int code, String message, K data) {
        return make(code, message , data);
    }



    public static <K> CommonResult<K> error(int code, String message) {
        return make(code, message, null);
    }

    public static <K> CommonResult<K> error(int code, String message, K data) {
        return make(code, message, data);
    }

    @Override
    public String toString() {
        return "CommonResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
