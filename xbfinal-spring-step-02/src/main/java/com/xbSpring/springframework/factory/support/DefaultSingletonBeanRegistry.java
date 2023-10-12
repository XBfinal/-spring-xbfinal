package com.xbSpring.springframework.factory.support;

import com.xbSpring.springframework.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0
 * @Author 笑霸final
 * @Date 2023/10/7 20:41
 * @注释 默认的单例bean的注册方法
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    //容器
    private Map<String,Object> stringObjectMap = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return stringObjectMap.get(beanName);
    }

    protected void addSingleton(String beanName , Object singletonObject){
        stringObjectMap.put(beanName,singletonObject);
    }
}
