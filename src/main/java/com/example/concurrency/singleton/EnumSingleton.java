package com.example.concurrency.singleton;

public class EnumSingleton {

    private EnumSingleton() {
    }

    private enum SingletonEnum {

        instance;

        private final EnumSingleton enumSingleton;

        SingletonEnum(){
            enumSingleton = new EnumSingleton();
        }

        private EnumSingleton getInstance(){
            return enumSingleton;
        }
    }

    public static EnumSingleton getInstance(){
        return SingletonEnum.instance.enumSingleton;
    }
}
