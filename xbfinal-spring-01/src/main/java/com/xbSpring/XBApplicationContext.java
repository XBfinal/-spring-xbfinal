package com.xbSpring;

import com.xbFiles.service.UserService;
import jdk.nashorn.internal.ir.CallNode;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @version 1.0
 * @Author 笑霸final
 * @Date 2023/10/12 14:51
 * @注释
 */

@Slf4j
public class XBApplicationContext {
    private Class configClass;

    //单例池
    ConcurrentHashMap<String, Object> beans = new ConcurrentHashMap();
    //BeanDefinition 池
    ConcurrentHashMap<String, BeanDefinition> beanDefinitionMap
            = new ConcurrentHashMap<>();

    public XBApplicationContext(Class configClass) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.configClass = configClass;

        //扫描路径  放入BeanDefinition
        scan(configClass);

        //创建所有的单例Bean entrySet会返回key和value
        for (Map.Entry<String, BeanDefinition> stringBeanDefinitionEntry : beanDefinitionMap.entrySet()) {
            BeanDefinition beanDefinition = stringBeanDefinitionEntry.getValue();
            if ("singleton".equals(beanDefinition.getScope())) {
                //创建
                Object o = creatBean(stringBeanDefinitionEntry.getValue().getName());
                //加入beanMap
                beans.put(stringBeanDefinitionEntry.getKey(),o);
            }
        }



    }

    /**
     * 创建Bean
     */
    public Object creatBean(String name)  {
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        Class clazz = beanDefinition.getClazz();
        try{
            Object instance = clazz.getDeclaredConstructor().newInstance();
            return instance;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 扫描
     *
     * @param configClass
     * @throws ClassNotFoundException
     */
    private void scan(Class configClass) throws ClassNotFoundException {
        //解析  配置类
        ComponentScan componentScanAnnotation
                = (ComponentScan) configClass.getDeclaredAnnotation(ComponentScan.class);
        //得到扫描路径
        String path = componentScanAnnotation.value();
        log.info("当前扫描路径：{}", path);
        //扫描  根据包名得到包下面的类
        ClassLoader classLoader = XBApplicationContext.class.getClassLoader();
        URL resource = classLoader.getResource(path.replace(".", "/"));

        File file = new File(resource.getFile());
        if (file.isDirectory()) {
            //查看该目录下有哪些文件
            File[] files = file.listFiles();
            for (File file1 : files) {
                //会打印D:\aProgramming\java\xbfinal-spring\xbfinal-spring-01\target\classes\com\xbFiles\service\UserService.class
                log.info("扫描到：{}", file1);
                String name = file1.getName();
                //判断是否是class文件
                if (name.endsWith(".class")) {
                    String[] split = name.split("\\.");
                    //我们要判断该类上又没有注解 就要用类加载器 参数是类的全类名
                    String classPath = path +"."+ split[0];
                    log.info("类路径{}",classPath);
                    Class<?> aClass = classLoader.loadClass(classPath);
                    //判断是否有 @Component
                    if (aClass.isAnnotationPresent(Component.class)) {
                        Component declaredAnnotation = aClass.getDeclaredAnnotation(Component.class);
                        String beanName = declaredAnnotation.value();//拿到名字
                        BeanDefinition beanDefinition = new BeanDefinition();
                        if (aClass.isAnnotationPresent(Scope.class)) {
                            Scope declaredAnnotation1 = aClass.getDeclaredAnnotation(Scope.class);
                            String value1 = declaredAnnotation1.value();
                            if (value1 == null || "singleton".equals(value1)) {
                                //单例
                                beanDefinition.setScope("singleton");
                            } else {//非单例
                                beanDefinition.setScope(value1);
                            }
                        } else {
                            //单例
                            beanDefinition.setScope("singleton");
                        }
                        //存入当前beanDefinitionMap
                        beanDefinition.setClazz(aClass);
                        beanDefinition.setName(beanName);
                        beanDefinitionMap.put(beanName, beanDefinition);
                    }

                }

            }

        }
    }

    public Object getBean(String beanName) throws InstantiationException, IllegalAccessException {
        if (beanDefinitionMap.containsKey(beanName)) {
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
            if ("singleton".equals(beanDefinition.getScope())) {
                //单例 从单例池拿
                return beans.get(beanName);
            } else {
                return creatBean(beanName);
            }
        } else {
            //不存在
            throw new NullPointerException();
        }
    }
}
