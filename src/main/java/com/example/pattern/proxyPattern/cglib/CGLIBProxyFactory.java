package com.example.pattern.proxyPattern.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGLIBProxyFactory implements MethodInterceptor {

    private Object target;

    public CGLIBProxyFactory(Object target){
        this.target = target;
    }

    public Object getProxyInstance(){

        Enhancer en = new Enhancer();

        // 运行时在内存中动态生成一个子类对象从而实现对目标对象功能的扩展
        // 要求target不能为final
        en.setSuperclass(target.getClass());

        // 设置回调函数，当通过proxy，调用对象方法时，会执行该函数
        en.setCallback(this);

        return en.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("Begin CGLIB statement");

        Object returnValue = method.invoke(target, objects);

        System.out.println("Close CGLIB statement");

        return returnValue;
    }
}
