package com.hsbc.transaction.common;

import lombok.Data;

/**
 * description:
 *
 * @author siminglang
 * @date 2025/5/13 19:12
 */
@Data
public class R<T> {
    private T data;
    private String message;
    private int code;
    private R(T data, String message,int code) {
        this.data = data;
        this.message = message;
        this.code = code;
    }
    private R(String message) {this.message = message;}

    public static <T> R<T> success(T data) {
        return new R<>(data,"SUCCESS",200);
    }

    public static <T> R<T> error(String message,int code) {
        return new R<>(null,message, code);
    }

    public T getData() {
        return data;
    }

    public int getCode() {
        return code;
    }

}
