package com.xbfinal.springframework;

import com.xbfinal.springframework.factory.config.BeanDefinition;
import com.xbfinal.springframework.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

/**
 * @version 1.0
 * @Author 笑霸final
 * @Date 2023/10/7 20:12
 * @注释
 */
public class SpringTest {
    @Test
    public void test_BeanFactory(){
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2.注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        // 3.第一次获取 bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.sayOk();
        System.out.println(userService);
        // 4.第二次获取 bean from Singleton
        UserService userService_singleton = (UserService) beanFactory.getBean("userService");
        userService_singleton.sayOk();
        System.out.println(userService_singleton);
    }

}
