package com.werkasowa.fx.view;

import java.io.IOException;
import java.util.Scanner;

public class View implements Runnable {

    Scanner scanner = new Scanner(System.in);

    public void run() {
        try {
            while (true) {

                System.out.println("Press 'Enter' to enter the menu");
//                enterMenu();
//                clearScreen();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("View interrupted");
        }

    }

    private void clearScreen() {

        System.out.print("\\033[H\\033[2J");

//        for (int i = 0; i < 20; i++) System.out.println("\n");

//        try {
//            Runtime.getRuntime().exec("clear");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    private void enterMenu() {
        String readString = scanner.nextLine();
        System.out.println(readString);
        if (readString.equals(""))
            System.out.println("Enter Key pressed.");
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
