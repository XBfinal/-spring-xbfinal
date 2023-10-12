package com.xbSpring.springframework.factory.config;

/**
 * @version 1.0
 * @Author 笑霸final
 * @Date 2023/10/7 20:40
 * @注释 单列bean的注册 接口
 */
public interface SingletonBeanRegistry {
    //得到 单例bean
    Object getSingleton(String beanName);
}
