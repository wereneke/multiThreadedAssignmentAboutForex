package com.werkasowa.fx.runnable;


public class Printer implements Runnable {

    public void run() {

        try {
            while (true) {
                ;
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
