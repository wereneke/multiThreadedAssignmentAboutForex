package com.werkasowa.fx;


import com.werkasowa.fx.runnable.TickContainer;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        TickContainer ticks = new TickContainer();

        ticks.addPair("EURUSD");

        Thread ticking = new Thread(ticks);
        ticking.start();

        while (ticking.isAlive()) {
            Arrays.asList(ticks.getTicks()).forEach(System.out::println);
        }
    }
}
