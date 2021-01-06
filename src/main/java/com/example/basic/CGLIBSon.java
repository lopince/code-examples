package com.example.basic;

import java.util.concurrent.Executors;

public class CGLIBSon extends CGLIBFather{

    public static void main(String[] args) {

        CGLIBSon son = new CGLIBSon();
        son.aopCall();

        Executors.newCachedThreadPool();
    }

    public void aopCall(){
        System.out.println("aop waving");
        call();
        System.out.println("aop waving");
    }
}
