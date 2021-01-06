package com.example.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.function.Consumer;

public class NIOServer {

    private Selector selector;
    private ServerSocketChannel serverSocketChannel;

    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 8111;

    public NIOServer() throws IOException {

        initServerSocketChannel();
        initSelector();
    }

    public void initServerSocketChannel() throws IOException {
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress(SERVER_HOST, SERVER_PORT));
    }

    public void initSelector() throws IOException {
        selector = Selector.open();

        // 将chanel注册到selector，指定感兴趣的事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }

    public void listen() throws IOException {

        System.out.println("[NIOServer] Listening");

        while (true) {

            // 阻塞到至少有一个通道在你注册的事件上就绪了
            selector.select();

            for (SelectionKey selectionKey : selector.selectedKeys()) {

                if (!selectionKey.isValid()) {
                    System.out.println("[NIOServer] Invalid channel");
                    continue;
                }

                System.out.println(
                        String.format(
                                "[NIOServer] Next selectionKey: isAcceptable=%s, isReadable=%s, isWritable=%s",
                                selectionKey.isAcceptable(),
                                selectionKey.isReadable(),
                                selectionKey.isWritable()));

                if (selectionKey.isAcceptable()) {
                    handleAcceptable();

                } else if (selectionKey.isReadable()) {
                    handleReadable(selectionKey);
                }
            }

            selector.selectedKeys().clear();
        }
    }

    private void handleAcceptable() throws IOException {

        System.out.println("[NIOServer] Accepted");

        SocketChannel socketChannel = serverSocketChannel.accept();
        socketChannel.configureBlocking(false);

        // 将chanel注册到selector，指定感兴趣的事件
        socketChannel.register(selector, SelectionKey.OP_READ);
    }

    private void handleReadable(SelectionKey selectionKey) throws IOException {

        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(256);

        if (socketChannel.read(byteBuffer) != -1) {
            System.out.println("[NIOServer] Received msg: " + new String(byteBuffer.array()));
        } else {
            socketChannel.close();
        }
    }

    public static void main(String[] args) throws Exception {

        NIOServer nioServer = new NIOServer();
        nioServer.listen();
    }
}
