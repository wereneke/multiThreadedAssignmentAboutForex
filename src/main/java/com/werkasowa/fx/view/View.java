package com.werkasowa.fx.view;

import java.util.Scanner;

public class View implements Runnable {

    public void run() {
        try {

            while (true) {
                Thread.sleep(1000);
                System.out.println("view running");
//                throw new InterruptedException();
            }
        } catch (InterruptedException e) {
//            e.printStackTrace();
            System.out.println("view interrupted");
        }

    }

    Scanner in = new Scanner(System.in);

    public boolean newTracking() {
        System.out.println("Do you want start another tracking? Y/N" + "\n");
        if (in.nextLine().toUpperCase().equals("Y")) return true;
        else return false;
    }

    public String getPair() {
        System.out.println("Give symbol (ex. EURUSD) you want to track");
        String pair = in.nextLine();
        return pair;
    }

    public boolean toRun(String command) {

        System.out.println("enter " + command + " to exit" + "\n");
        String answer = in.nextLine();
        if (answer.equals(command)) return false;
        else return true;
    }


}
