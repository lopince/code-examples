package com.example.pattern.proxyPattern.staticc;

public class UserDaoProxyDemo {

    public static void main(String[] args) {

        IUserDao target = new UserDao();

        UserDaoProxy proxyUserDao = new UserDaoProxy(target);
        proxyUserDao.save();
    }
}
