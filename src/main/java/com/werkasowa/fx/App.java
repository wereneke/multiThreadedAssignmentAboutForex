package com.werkasowa.fx;


import com.werkasowa.fx.runnable.Ticking;
import com.werkasowa.fx.view.View;

public class App {

    Thread viewThread = new Thread(new View());
    public static void main(String[] args) {

        App app = new App();
        boolean run = true;

        app.viewThread.start();
        app.viewThread.sleep(3000);
        app.viewThread.interrupt();

    }

}
