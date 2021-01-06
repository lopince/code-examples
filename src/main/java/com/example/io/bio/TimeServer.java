package com.example.io.bio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

public class TimeServer {

    public static void main(String[] args) {

        ServerSocket server = null;
        try{
            server = new ServerSocket(8080);
            System.out.println("TimeServer started on 8080...");

            while (true){
                Socket client = server.accept();

                // Server端每次需要new一个线程处理一个新的client请求
                new Thread(new TimeServerHandler(client)).start();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static class TimeServerHandler implements Runnable{

        private Socket client;

        public TimeServerHandler(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {

            BufferedReader reader = null;
            PrintWriter writer = null;

            try{
                reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                writer = new PrintWriter(client.getOutputStream());

                while (true){
                    String request = reader.readLine();
                    System.out.println("Received request: " + request);

                    writer.println(Calendar.getInstance().getTime().toLocaleString());
                    writer.flush();
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                try{
                    writer.close();
                    reader.close();

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
