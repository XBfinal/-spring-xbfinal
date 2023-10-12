package com.xbSpring;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @version 1.0
 * @Author 笑霸final
 * @Date 2023/10/12 21:15
 * @注释 自动注入
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD , ElementType.FIELD})//只能定义在类上
public @interface Autowired {

}
