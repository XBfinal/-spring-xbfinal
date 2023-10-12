package com.xbSpring.springframework;

import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0
 * @Author 笑霸final
 * @Date 2023/10/7 19:57
 * @注释 代表了 Bean 对象的工厂，可以存放 Bean 定义到 Map 中以及获取。
 */
public class BeanFactory {
    // Bean 的注册，这里注册的是 Bean 的定义信息
    private Map<String,BeanDefinition> beanDefinitionMap =new HashMap<>();

    //获取 Bean 的操作。
    public Object getBeanDefinitionMap(String name) {
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        return beanDefinition.getBean();
    }

    //注册bean
    public void registerBeanDefinition(String name , BeanDefinition beanDefinition){
        beanDefinitionMap.put(name, beanDefinition);
    }
}
