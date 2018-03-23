package com.werkasowa.fx;

import com.werkasowa.fx.view.View;

public class App {

    public static void main(String[] args) {

    Thread viewThread = new Thread(new View());

        try {
            viewThread.start();
            viewThread.sleep(1000);
            viewThread.interrupt();
        }catch (InterruptedException e) {}


    }

}
