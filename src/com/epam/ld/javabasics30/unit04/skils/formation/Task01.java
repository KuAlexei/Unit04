package com.epam.ld.javabasics30.unit04.skils.formation;

import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {
        int x;
        int y;
        Scanner sc = new Scanner(System.in);
        x = readIntFromConsole(sc, "Введите x: ");
        y = readIntFromConsole(sc, "Введите y: ");
        System.out.println("sum = " + sum(x, y) + "; mul = " + mul(x, y));
    }

    public static int readIntFromConsole(Scanner sc, String message) {
        System.out.println(message);
        while (!sc.hasNextInt()) {
            sc.next();
        }
        return sc.nextInt();
    }

    public static int sum(int a, int b) {
        return a + b;
    }

    public static int mul(int a, int b) {
        return a * b;
    }
}
