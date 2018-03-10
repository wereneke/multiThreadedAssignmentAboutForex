package com.werkasowa.fx.runnable;

import com.werkasowa.fx.view.View;

public class Printer implements Runnable {

    public void run() {

        View view = new View();
        try {
            while (true) {
                view.printQuotes();
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

        }
    }



//    public boolean newTracking() {
//        System.out.println("Do you want start another tracking? Y/N" + "\n");
//        if (in.nextLine().toUpperCase().equals("Y")) return true;
//        else return false;
//    }
//
//    public String getPair() {
//        System.out.println("Give symbol (ex. EURUSD) you want to track");
//        String pair = in.nextLine();
//        return pair;
//    }
//
//    public boolean toRun(String command) {
//
//        System.out.println("enter " + command + " to exit" + "\n");
//        String answer = in.nextLine();
//        if (answer.equals(command)) return false;
//        else return true;
//    }


}
