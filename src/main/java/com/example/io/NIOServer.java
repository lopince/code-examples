package com.example.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NIOServer {

    private Selector selector;
    private ServerSocketChannel serverSocketChannel;

    public NIOServer(String host, int port) throws IOException {

        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel
                .socket()
                .bind(new InetSocketAddress(host, port));

        selector = Selector.open();

        // 向Selector注册Channel
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }

    public void listen() throws IOException {

        System.out.println("NIO server listening ...");

        while (true) {

            // 然后调用它的select()，这个方法会一直阻塞到某个注册的通道有事件就绪
            selector.select();
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {

                SelectionKey key = iterator.next();
                if (key.isAcceptable()) {
                    accept();

                } else if (key.isReadable()) {
                    receiveAndReply(key);
                }

                iterator.remove();
            }
        }
    }

    private void accept() throws IOException {

        SocketChannel channel = serverSocketChannel.accept();
        channel.configureBlocking(false);
        channel.register(selector, SelectionKey.OP_READ);
    }

    private void receiveAndReply(SelectionKey key) throws IOException {

        SocketChannel channel = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(256);
        int i = channel.read(buffer);
        if (i != -1) {
            String msg = new String(buffer.array()).trim();
            System.out.println("NIO server received: " + msg);

            channel.write(ByteBuffer.wrap(msg.getBytes()));
            System.out.println("NIO server reply: " + msg);
        } else {
            channel.close();
        }
    }

    public static void main(String[] args) throws Exception {
        NIOServer server = new NIOServer("localhost", 8080);
        server.listen();
    }
}
