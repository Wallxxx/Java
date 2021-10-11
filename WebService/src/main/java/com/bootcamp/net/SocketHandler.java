package com.bootcamp.net;

import com.bootcamp.service.BankService;

import java.io.*;
import java.net.Socket;

public class SocketHandler implements Runnable {
    private Socket socket;
    private InputStream input;
    private OutputStream output;

    public SocketHandler(Socket socket) {
        try {
            this.socket = socket;
            this.input = socket.getInputStream();
            this.output = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(-1);
        }
    }

    public void run() {
        try {
            readAnswer();
            BankService bank = new BankService();
            //bank.select();
            sendAnswer("<html><body><h1>I NOT UNDERSTAND RUSSIAN LANGUAGE, UNDESTAND????</h1></body></html>");
        } catch (Throwable t) {
            // do nothing
        } finally {
            try {
                socket.close();
            } catch (Throwable t) {
                // do nothing
            }
        }
        System.out.println("Client processing finished");

    }

    private void sendAnswer(String answer) {
        String response = "HTTP/1.1 200 OK\r\n" +
                "Server: bootcamp/2021-10-07\r\n" +
                "Content-Type: text/html\r\n" + // Заменить на json
                "Content-Length: " + answer.length() + "\r\n" +
                "Connection: close\r\n\r\n";
        String result = response + answer;
        try {
            output.write(result.getBytes());
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readAnswer() {
        BufferedReader temp = new BufferedReader(new InputStreamReader(input));
        try {
            while (true) {
                String answer = temp.readLine();
                if (temp == null || answer.trim().length() == 0) break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
