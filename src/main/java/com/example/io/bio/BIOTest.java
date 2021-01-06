package com.example.io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class BIOTest {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress("localhost", 8888), 50);
        Socket socket;

        while ((socket = serverSocket.accept()) != null) {

            byte[] data = new byte[1024];

            System.out.println(new String(data, StandardCharsets.UTF_8));
            OutputStream os = socket.getOutputStream();
            os.write(data);

            InputStream is = socket.getInputStream();
            is.read(data);

            socket.close();
        }
    }
}
