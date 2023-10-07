package com.xbfinal.springframework.factory.support;

import com.xbfinal.springframework.BeansException;
import com.xbfinal.springframework.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0
 * @Author 笑霸final
 * @Date 2023/10/7 21:09
 * @注释 核心类实现(DefaultListableBeanFactory)
 */
public class DefaultListableBeanFactory extends  AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {


    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    @Override
    protected BeanDefinition getBeanDefinition(String beanName) {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) throw new BeansException("No bean named '" + beanName + "' is defined");
        return beanDefinition;
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }
}
