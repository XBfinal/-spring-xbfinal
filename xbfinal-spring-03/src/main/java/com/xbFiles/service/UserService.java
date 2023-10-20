package com.xbFiles.service;

import com.xbSpring.*;

/**
 * @version 1.0
 * @Author 笑霸final
 * @Date 2023/10/12 15:22
 * @注释
 */
@Scope("xxx")
@Component("userService")
public class UserService implements BeanNameAware , InitializingBean {

    @Autowired
    private OrderService orderService;

    private String beanName;
    @Override
    public void setName(String name) {
        this.beanName = name;
    }

    public void printOrderService(){
        System.out.println("自动注入验证==》orderService: "+orderService);
        System.out.println("BeanNameAware接口验证===》beanName: "+beanName);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("验证InitializingBean 初始化 ~~~ 逻辑有程序员自己实现");
    }

}
