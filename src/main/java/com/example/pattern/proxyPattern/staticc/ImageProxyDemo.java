package com.example.pattern.proxyPattern.staticc;

public class ImageProxyDemo {

    public static void main(String[] args) {

        // 通过proxyImage获取RealImage类的对象
        // ProxyImage与RealImage均实现Image接口
        // 但ProxyImage的实现，基于对RealImage的包裹
        // 实际上不能直接使用RealImage。只能通过ProxyImage，间接使用RealImage
        Image image = new ImageProxy("test_10mb.jpg");

        image.display();
        System.out.println();
        image.display();
    }
}
