package com.xbfinal.springframework;

/**
 * @version 1.0
 * @Author 笑霸final
 * @Date 2023/10/7 19:57
 * @注释  BeanDefinition，用于定义 Bean 实例化信息，现在的实现是以一个 Object 存放对象
 */
public class BeanDefinition {
    private Object bean;

    public BeanDefinition(Object bean){
        this.bean = bean;
    }

    //得到bean
    public Object getBean() {
        return bean;
    }
}
