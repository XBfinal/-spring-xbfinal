package com.xbfinal.springframework.factory.support;

import com.xbfinal.springframework.factory.config.BeanDefinition;

/**
 * @version 1.0
 * @Author 笑霸final
 * @Date 2023/10/7 21:06
 * @注释
 */
public abstract class AbstractAutowireCapableBeanFactory extends  AbstractBeanFactory{

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) {
        Object bean = null;
        try{
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //此方法是DefaultSingletonBeanRegistry中的 保存单例bean
        addSingleton(beanName,bean);
        return bean;
    }
}
