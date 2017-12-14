package com.powerboat9.KBOT;

public class Main {
    public static void main(String[] args) {
        KahootSearch search = KahootSearch.getInstance();
        for (int i = 0; i < 55555; ++i) {
            if (search.check(i)) System.out.println(i + ": OK");
            else if ((i % 10) == 0) System.out.println(i + ": --");
        }
        //KahootConnection c = KahootConnection.getInstance(0);
    }
}
