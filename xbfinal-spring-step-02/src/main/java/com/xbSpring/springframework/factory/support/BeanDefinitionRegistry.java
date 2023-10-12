package com.xbSpring.springframework.factory.support;

import com.xbSpring.springframework.factory.config.BeanDefinition;

/**
 * @version 1.0
 * @Author 笑霸final
 * @Date 2023/10/7 21:10
 * @注释
 */
public interface BeanDefinitionRegistry {
    /**
     * 向注册表中注册 BeanDefinition
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
