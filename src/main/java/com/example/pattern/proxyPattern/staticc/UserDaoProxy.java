package com.example.pattern.proxyPattern.staticc;

public class UserDaoProxy implements IUserDao {

    private IUserDao target;

    public UserDaoProxy(IUserDao target) {
        this.target = target;
    }


    @Override
    public void save() {
        target.save();
    }

    @Override
    public void save2() {
        target.save2();
    }
}
