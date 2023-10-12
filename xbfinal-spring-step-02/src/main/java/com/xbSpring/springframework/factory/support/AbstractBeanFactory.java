package com.xbSpring.springframework.factory.support;

import com.xbSpring.springframework.factory.BeanFactory;
import com.xbSpring.springframework.factory.config.BeanDefinition;

/**
 * @version 1.0
 * @Author 笑霸final
 * @Date 2023/10/7 20:52
 * @注释
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String name) {
        //调用继承DefaultSingletonBeanRegistry的getSingleton 实现的方法
        Object bean = getSingleton(name);
        if(bean != null){
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name,beanDefinition);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) ;
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition);

}
