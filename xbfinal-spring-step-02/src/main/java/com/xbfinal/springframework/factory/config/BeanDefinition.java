package com.xbfinal.springframework.factory.config;

/**
 * @version 1.0
 * @Author 笑霸final
 * @Date 2023/10/7 19:57
 * @注释  BeanDefinition，用于定义 Bean 实例化信息，现在的实现是以一个 Object 存放对象
 */
public class BeanDefinition {

    // 定义成 Class 这样就可以把 Bean 的实例化操作放到容器中处理了。
    private Class beanClass;
    public BeanDefinition(Class beanClass){
        this.beanClass = beanClass;
    }
    public Class getBeanClass() {
        return beanClass;
    }
    public void setBeanClass(Class beanClass){
        this.beanClass = beanClass;
    }
}
