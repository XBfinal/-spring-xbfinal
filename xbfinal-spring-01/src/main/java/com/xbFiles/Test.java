package com.xbFiles;

import com.xbSpring.XBApplicationContext;

/**
 * @version 1.0
 * @Author 笑霸final
 * @Date 2023/10/12 15:02
 * @注释
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        XBApplicationContext xbApplicationContext = new XBApplicationContext(AppConfig.class);
        Object userService = xbApplicationContext.getBean("userService");
        System.out.println(userService);
        Object userService1 = xbApplicationContext.getBean("userService");
        System.out.println(userService1);

    }
}

