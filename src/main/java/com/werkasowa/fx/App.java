package com.werkasowa.fx;


import com.werkasowa.fx.runnable.TickContainer;

import java.util.Arrays;

public class App {

    public static void main(String[] args) throws InterruptedException {

        TickContainer ticks = new TickContainer();

        ticks.addPair("EURUSD");
        ticks.addPair("GBPAUD");

        Thread ticking = new Thread(ticks);
        ticking.start();

    }
}
