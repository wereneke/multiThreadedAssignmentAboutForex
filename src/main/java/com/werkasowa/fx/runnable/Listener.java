package com.werkasowa.fx.runnable;

import java.util.Scanner;

public class Listener implements Runnable {


    Thread printingThread;

    public Listener(Thread tPr) {
        this.printingThread = tPr;
    }

    public void run() {


            while (true) {
                Scanner scanner = new Scanner(System.in);
                if (scanner.hasNextLine()) {
                    System.out.println("Enter Key pressed.");
                    printingThread.interrupt();
                    scanner.close();
                }
//                Thread.sleep(1000);
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
