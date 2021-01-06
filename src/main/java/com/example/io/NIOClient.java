package com.example.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Vector;

public class NIOClient {

    private SocketChannel socketChannel;
    private ByteBuffer buffer;

    public NIOClient(String host, int port) throws IOException {

        socketChannel = SocketChannel.open(new InetSocketAddress(host, port));
    }

    public void send(String msg) throws IOException {

        byte[] data = msg.getBytes();
        buffer = ByteBuffer.wrap(data);
        socketChannel.write(buffer);

        buffer.clear();
    }

    public String read() throws IOException {

        socketChannel.read(buffer);
        return new String(buffer.array());
    }

    public void close() throws IOException {
        socketChannel.close();
    }

    public static void main(String[] args) throws IOException {

        NIOClient client = new NIOClient("localhost", 8080);

        String msg = "I am a client";
        client.send(msg);
        System.out.println("NIO client sent: " + msg);

        System.out.println("NIO client received: " + client.read());

        client.close();
    }
}
