package com.bootcamp;

import com.bootcamp.net.SocketHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }
}
    /*public static void main(String[] args) {
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
    }*/
