package com.epam.ld.javabasics30.unit04.skils.consolidation;

import java.util.Random;
import java.util.Scanner;

public class Task02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Проверим знание таблицы умножения.");
        int a = getRandomInt(10);
        int b = getRandomInt(10);
        System.out.printf("Сколько будет %dx%d? ", a, b);
        int answer=0;
        if (sc.hasNextInt()) {
            answer = sc.nextInt();
            if (answer == a*b) {
                System.out.println("Правильно!");
            } else {
                System.out.println("Неправильно!");
            }
        }
    }

    public static int getRandomInt(int maxInt) {
        Random rnd  = new Random();
        return rnd.nextInt(maxInt);
    }

}
