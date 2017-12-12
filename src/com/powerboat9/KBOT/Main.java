package com.powerboat9.KBOT;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 55555; ++i) {
            if (KahootSearch.check(i)) System.out.println(i + ": OK");
            else if ((i % 10) == 0) System.out.println(i + ": --");
        }
    }
}
