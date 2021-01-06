package com.example.pattern.proxyPattern.dynamic;

import com.example.pattern.proxyPattern.staticc.IUserDao;
import com.example.pattern.proxyPattern.staticc.UserDao;

public class UserDaoDynamicProxyDemo {

    public static void main(String[] args) {

        IUserDao target = new UserDao();
        System.out.println(target.getClass());

        // 动态代理在运行时生成，并没有实际的class文件，只是动态生成类字节码
        IUserDao proxy = (IUserDao) new UserDaoDynamicProxyFactory(target).getProxyInstance();
        System.out.println(proxy.getClass());

        proxy.save2();
    }
}
