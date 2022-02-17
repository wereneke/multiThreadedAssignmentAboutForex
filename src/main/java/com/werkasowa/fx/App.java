package com.werkasowa.fx;

import com.werkasowa.fx.runnable.Controller;

public class App {

    public static void main(String[] args) {
        Thread controlling = new Thread(new Controller());
        controlling.start();
    }
}
