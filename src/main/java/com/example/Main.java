package com.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Runner runner = new Runner();

        System.out.print("Write a mode (encode, send, decode): ");
        String mode = scanner.nextLine().trim().toLowerCase();

        runner.run(mode);
    }
}