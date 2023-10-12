package com.xbFiles.service;

import com.xbSpring.BeanPostProcessor;
import com.xbSpring.Component;

/**
 * @version 1.0
 * @Author 笑霸final
 * @Date 2023/10/12 22:16
 * @注释
 */
@Component("xbfinalProcessor")
public class XbfinalProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String name) {
        if("userService".equals(name)){
            System.out.println("spring的初始化之前");
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String name) {
        System.out.println("spring的初始化之后");
        return bean;
    }
}
