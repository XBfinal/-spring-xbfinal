package com.xbSpring;

/**
 * @version 1.0
 * @Author 笑霸final
 * @Date 2023/10/12 16:17
 * @注释
 */
public class BeanDefinition {
    private Class clazz;
    private String scope;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;



    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
