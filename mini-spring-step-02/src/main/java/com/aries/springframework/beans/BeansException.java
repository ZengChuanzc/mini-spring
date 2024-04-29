package com.aries.springframework.beans;

/**
 * @author zengchuan
 * @version 1.0
 * @date 2024/4/25 17:39
 * @description BeansException
 */
public class BeansException extends RuntimeException{

    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
