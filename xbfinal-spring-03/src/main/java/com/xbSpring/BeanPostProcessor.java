package com.xbSpring;

/**
 * @version 1.0
 * @Author 笑霸final
 * @Date 2023/10/12 22:03
 * @注释
 */
public interface BeanPostProcessor {
    /**
     * 初始化之前
     * @param bean
     * @param name
     * @return
     */
    Object postProcessBeforeInitialization(Object bean , String name);

    /**
     * 初始化之后
     * @param bean
     * @param name
     * @return
     */
    Object postProcessAfterInitialization(Object bean , String name);

}
