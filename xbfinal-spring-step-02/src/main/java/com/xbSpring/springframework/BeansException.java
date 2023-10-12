package com.xbSpring.springframework;

/**
 * @version 1.0
 * @Author 笑霸final
 * @Date 2023/10/7 21:16
 * @注释
 */
public class BeansException extends RuntimeException{
    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
