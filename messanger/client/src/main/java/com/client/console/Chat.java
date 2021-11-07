package com.client.console;

import com.client.auth.AuthMe;
import com.client.items.ListItem;
import com.client.messages.Messages;

import java.util.Objects;
import java.util.Scanner;

public class Chat {

    private final String with;
    private final Scanner scanner;

    public Chat(String address) {
        this.with = address;
        scanner = new Scanner(System.in);
    }

    public void show() {
        System.out.print("<-- Back / Chats / Chat with " + with + "\n\n");
        while (true) {
            checkUpdate();
            System.out.print("*" + AuthMe.getLogin() + ": ");
            String message = scanner.next();
            if (Objects.equals(message, "@back")) break;
            if (Objects.equals(message, "@u") || Objects.equals(message, "@upd") ||
                    Objects.equals(message, "@update")) {
                checkUpdate();
                continue;
            }
            send(message);
        }
    }

    private void send(String message) {
        Messages.send(with, message);
    }

    private void checkUpdate() {
        for (ListItem items : Objects.requireNonNull(Messages.getMessages())) {
            System.out.print("*" + items.sender + ": ");
            System.out.println(items.message);
        }
    }
}
