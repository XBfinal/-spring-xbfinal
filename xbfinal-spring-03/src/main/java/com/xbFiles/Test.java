package com.xbFiles;

import com.xbFiles.service.UserService;
import com.xbSpring.XBApplicationContext;

import java.lang.reflect.InvocationTargetException;

/**
 * @version 1.0
 * @Author 笑霸final
 * @Date 2023/10/12 15:02
 * @注释
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        XBApplicationContext xbApplicationContext = new XBApplicationContext(AppConfig.class);
        UserService userService = (UserService)xbApplicationContext.getBean("userService");
        userService.printOrderService();
    }
}

