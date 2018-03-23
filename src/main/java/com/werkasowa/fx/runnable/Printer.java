package com.werkasowa.fx.runnable;

import com.werkasowa.fx.tick.GetTicksJson;
import com.werkasowa.fx.view.View;

public class Printer implements Runnable {

    public void run() {

        View view = new View();
        try {
            while (true) {
                view.printQuotes(new GetTicksJson().sendGet("EURUSD"));
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {

            // to change --------------------------------
            System.out.println("Printer interrupted");
            try {
                Thread.sleep(3000);
                new Printer().run();
            } catch (InterruptedException e1) {}
            // ------------------------------------------

        } catch (Exception e) {
            e.printStackTrace();
        }
    }






}
