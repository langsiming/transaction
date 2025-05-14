package com.hsbc.transaction.common;

/**
 * description:
 *
 * @author siminglang
 * @date 2025/5/13 21:21
 */
public class BusinessException extends RuntimeException{
    public BusinessException(String message) {
        super(message);
    }
}
