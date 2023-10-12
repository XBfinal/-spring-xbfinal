package com.xbSpring;

/**
 * @version 1.0
 * @Author 笑霸final
 * @Date 2023/10/12 16:05
 * @注释
 */
public @interface Scope {
    String value() default "singleton";
}
