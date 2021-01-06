package com.example.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.time.LocalDateTime;

public class NIOClient {

    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 8111;

    public static void main(String[] args) throws Exception {

        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress(SERVER_HOST, SERVER_PORT));

        String msg = "Msg from NIOClient[" + LocalDateTime.now() + "]";

        byte[] msgBytes = msg.getBytes();
        ByteBuffer byteBuffer = ByteBuffer.wrap(msgBytes);

        socketChannel.write(byteBuffer);
        byteBuffer.clear();


        socketChannel.close();
    }
}
