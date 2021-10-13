package com.bootcamp.util;

public class GeneratorNumberCard {

    public String generate() {
        return "1274 " + String.format("%04d", (int)(Math.random() * 10000)) + " " +
                String.format("%04d", (int)(Math.random() * 10000)) + " " +
                String.format("%04d", (int)(Math.random() * 10000));
    }
}
