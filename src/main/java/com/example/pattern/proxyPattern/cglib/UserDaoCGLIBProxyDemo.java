package com.example.pattern.proxyPattern.cglib;

import com.example.pattern.proxyPattern.staticc.UserDao;

public class UserDaoCGLIBProxyDemo {

    public static void main(String[] args) {

        UserDao target = new UserDao();
        System.out.println(target.getClass());

        UserDao proxy = (UserDao) new CGLIBProxyFactory(target).getProxyInstance();
        System.out.println(proxy.getClass());

        proxy.save();
    }
}
