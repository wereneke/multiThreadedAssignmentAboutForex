package com.werkasowa.fx.runnable;

public class Printer implements Runnable {

    public void run() {
        try {
            while (true) {
                System.out.println("Press 'Enter' to enter the menu");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("View interrupted");
            try {
                Thread.sleep(3000);
                new Printer().run();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
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
