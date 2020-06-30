package com.epam.ld.javabasics30.unit04.skils.consolidation;

import java.util.Scanner;

public class Task03 {

    private static final String TABLE_TOP = "\u2554\u2550\u2550\u2550\u2550\u2550\u2566\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2566\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2557";
    private static final String TABLE_MIDDLE = "\u2560\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2563";
    private static final String TABLE_BOTTOM = "\u255A\u2550\u2550\u2550\u2550\u2550\u2569\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2569\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u255D";
    private static final String LINE_FORMAT = "\u2551 %3s \u2551 %5.4g \u2551 %5.4g \u2551\n";

    private static final Currency[] rates = {new Currency("USD", 2.2342, 2.3452), new Currency("EUR", 2.6345, 2.7345)};
    private static final String MENU_FORMAT = "%2$3d. %1$s\n";

    public static void main(String[] args) {
        printCurrencyRatesTable();
        boolean operation; // TRUE - Покупка, FALSE - Продажа
        Scanner sc = new Scanner(System.in);
        String s="";
        while (true) {
            System.out.println();
            System.out.println("  1. Купить");
            System.out.println("  2. Продать");
            System.out.println("  0. Выход");
            s = sc.nextLine();
            if (operation = "1".equals(s)) {
                break;
            } else if ("2".equals(s)) {
                break;
            } else if ("0".equals(s)) {
                return;
            } else System.out.print("Повторите ввод.");
        }
        Currency currency = chooseCurrency(sc);
        System.out.println("Сколько " + currency.name + " желаете " + (operation?"купить":"продать") + ": ");
        if (sc.hasNextDouble()) {
            double amount = sc.nextDouble();
            if (operation) {
                printOperation("BYN", currency.name, currency.sell*amount);
            } else {
                printOperation(currency.name, "BYN", currency.buy*amount);
            }
        }
    }

    public static Currency chooseCurrency(Scanner sc) {
        while (true) {
            System.out.println();
            for (int i=0; i<rates.length; ){
                System.out.printf(MENU_FORMAT, rates[i].name, ++i);
            }
            System.out.printf(MENU_FORMAT, "Выход", 0);
            if (sc.hasNextInt()) {
                int c = sc.nextInt();
                if (c == 0) {
                    System.exit(0);
                }
                if ((c > 0) && (c <= rates.length)) {
                    return rates[c - 1];
                } else System.out.print("Повторите ввод.");
            } else {
                sc.nextLine();
                System.out.print("Повторите ввод.");
            }
        }
    }

    public static void printCurrencyRatesTable() {
        System.out.println(TABLE_TOP);
        System.out.println("\u2551     \u2551Покупка\u2551Продажа\u2551");
        for (Currency c:rates) {
            System.out.println(TABLE_MIDDLE);
            System.out.printf(LINE_FORMAT, c.name, c.buy, c.sell);
        }
        System.out.println(TABLE_BOTTOM);
    }

    public static void printOperation(String curr1, String curr2, double total) {
        System.out.printf("%s -> %s : %g\n", curr1, curr2, total);
    }

    private static class Currency {
        public final String name;
        public final double buy;
        public final double sell;

        Currency(String name, double buy, double sell) {
            this.name = name;
            this.buy = buy;
            this.sell = sell;
        }
    }

}
// Отлично. Спасибо за аккуратность. К 4-му модулю уже стала распознавать ваш стиль) Задачи зачтены
