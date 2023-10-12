package com.xbSpring;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @version 1.0
 * @Author 笑霸final
 * @Date 2023/10/12 14:55
 * @注释 扫描路径
 */
@Target(ElementType.TYPE)//只能定义在类上
@Retention(RetentionPolicy.RUNTIME)
public @interface ComponentScan {

    String value();
}
