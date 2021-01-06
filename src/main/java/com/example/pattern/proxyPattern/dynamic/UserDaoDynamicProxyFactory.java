package com.example.pattern.proxyPattern.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserDaoDynamicProxyFactory {

    private Object target;

    public UserDaoDynamicProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {

        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),

                // 虽然不要求proxy factory继承接口，但要求目标对象必须实现接口
                target.getClass().getInterfaces(),

                // newInvocationHandler: 处理代理对象的接口方法的调用
                (proxy, method, args) -> {

                    System.out.println("Begin statement");

                    // 此处并不只针对某个接口方法
                    // 对接口的所有方法，统一使用该handler进行处理
                    Object returnValue = method.invoke(target, args);

                    System.out.println("Submit statement");

                    return returnValue;
                });
    }
}
