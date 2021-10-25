package com.ushakov;

import com.ushakov.menu.Menu;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        while (true) menu.showMenu();
    }
}
