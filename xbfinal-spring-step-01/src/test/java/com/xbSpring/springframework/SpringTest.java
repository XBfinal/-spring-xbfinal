package com.xbSpring.springframework;

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
        BeanFactory beanFactory = new BeanFactory();

        BeanDefinition beanDefinition = new BeanDefinition(new UserService());

        beanFactory.registerBeanDefinition("userName",beanDefinition);

        //获取bean
        UserService userName = (UserService)beanFactory.getBeanDefinitionMap("userName");
        userName.sayOk();

    }
}
