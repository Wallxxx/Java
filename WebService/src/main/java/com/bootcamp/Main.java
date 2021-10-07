package com.bootcamp;

import com.bootcamp.net.SocketHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try {
            ServerSocket socket = new ServerSocket(8080);
            while (true) { // Реализовать выход
                Socket inputConnection = socket.accept();
                System.out.println("Client accepted");
                new Thread(new SocketHandler(inputConnection)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
