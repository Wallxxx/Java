package com.client.console;

import com.client.auth.AuthMe;

import java.io.Console;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class Menu {

    private static String userLogin = null;
    private static final Scanner scanner = new Scanner(System.in);

    public static void show() {
        while (userLogin == null) {
            upLine();
            authShow();
            clear();
        }
        showActions();
    }

    private static void showActions() {
        while (true) {
            upLine();
            System.out.println("--> Chat");
            System.out.println("--> Log out");
            System.out.println("--> Exit (app)");
            String input = scanner.next().replace("\\s+", "").toLowerCase(Locale.ROOT);
            if (input.equals("1") || input.equals("chat") || input.equals("c")) {
                startChat();
            } else if (input.equals("2") || input.equals("log") || input.equals("out") || input.equals("lo") ||
                    input.equals("l") || input.equals("o")) {
                userLogin = null;
                AuthMe.logout();
                clear();
                show();
            } else if (input.equals("3") || input.equals("exit") || input.equals("quit") || input.equals("app") ||
                    input.equals("e") || input.equals("q") || input.equals("close")) {
                clear();
                break;
            }
        }
    }

    private static void startChat() {
        while (true) {
            clear();
            System.out.print("<-- Back / Actions / " + userLogin + "\n\n    Chat with: ");
            String sendAddress = scanner.next();
            if (Objects.equals(sendAddress, "@back")) break;
            Chat chat = new Chat(sendAddress);
            clear();
            chat.show();
        }
    }

    private static void upLine() {
        String line = "Wallxxx client / ";
        if (userLogin != null) {
            line = line + userLogin;
        }
        else {
            line = line + "{not authorized}";
        }
        System.out.println(line + "\n");
    }

    private static void authShow() {
        System.out.println("Sign in   /   Sign up");
        String input = scanner.next().replace("\\s+", "").toLowerCase(Locale.ROOT);
        if (input.equals("1") || input.equals("signin") || input.equals("in") || input.equals("si") ||
                input.equals("i")) {
            loginMenuShow('a');
        } else if (input.equals("2") || input.equals("signup") || input.equals("up") || input.equals("su") ||
                input.equals("u")) {
            loginMenuShow('r');
        }
    }

    private static void loginMenuShow(char action) {
        clear();
        if (action == 'a') {
            System.out.print("<-- Back / Sign in\n\n    Login: ");
        }
        else System.out.print("<-- Back / Sign up\n\n    Login: ");
        String login = scanner.next();
        if (Objects.equals(login, "@back")) return;
        String password = passwordMenuShow();
        if (action == 'a') {
            if (AuthMe.auth(login, password)) {
                userLogin = login;
            }
            else {
                System.out.println("    Wrong login or password. ");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                loginMenuShow('a');
            }
        }
        else {
            if (AuthMe.register(login, password)) {
                userLogin = login;
            }
            else {
                System.out.println("    Has already. ");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                loginMenuShow('r');
            }
        }
    }

    private static String passwordMenuShow() {
        Console console = System.console();
        char[] passwordChars = console.readPassword("    Password: ");
        return String.copyValueOf(passwordChars);
    }

    private static void clear() {
        try
        {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows"))
            {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
            e.printStackTrace();
        }
    }
}
