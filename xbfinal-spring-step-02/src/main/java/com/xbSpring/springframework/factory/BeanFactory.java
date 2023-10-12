package com.xbSpring.springframework.factory;

/**
 * @version 1.0
 * @Author 笑霸final
 * @Date 2023/10/7 19:57
 * @注释 代表了 Bean 对象的工厂，可以存放 Bean 定义到 Map 中以及获取。
 */
public interface  BeanFactory {
    Object getBean(String name);
}
