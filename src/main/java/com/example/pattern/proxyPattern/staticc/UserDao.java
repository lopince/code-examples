package com.example.pattern.proxyPattern.staticc;

public final class UserDao implements IUserDao {
    @Override
    public void save() {
        System.out.println("[UserDao] Saving data");
    }

    @Override
    public void save2() {
        System.out.println("[UserDao] Saving data 2");
    }
}
