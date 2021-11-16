package com.myooo.util;

import lombok.Data;

@Data
public class ResponseMessage<T> {

    private int code;

    private String message;

    private T data;

    public ResponseMessage() {
    }

    public ResponseMessage(int code, String message, T data) {
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

    private static <K> ResponseMessage<K> make(int code, String message, K data) {
        ResponseMessage<K> r = new ResponseMessage<>();
        r.code = code;
        r.message = message;
        r.data = data;
        return r;
    }

    public static <K> ResponseMessage<K> success(K data) {
        return make(0, "成功", data);
    }

    public static <K> ResponseMessage<K> success(int code, String message, K data) {
        return make(code, message , data);
    }



    public static <K> ResponseMessage<K> error(int code, String message) {
        return make(code, message, null);
    }

    public static <K> ResponseMessage<K> error(int code, String message, K data) {
        return make(code, message, data);
    }

    @Override
    public String toString() {
        return "ResponseMessage{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
