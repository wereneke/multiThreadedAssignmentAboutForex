package com.werkasowa.fx.view;

import java.util.Scanner;

public class View {

    Scanner in = new Scanner(System.in);

    public boolean newTracking() {
        System.out.println("Do you want start another tracking? Y/N" + "\n");
        if (in.next().toUpperCase().equals("Y")) return true;
        else return false;
    }

    public String getPair() {
        System.out.println("Give symbol (ex. EURUSD) you want to track");
        return in.next();
    }

    public boolean toRun(String command) {

        System.out.println("enter " + command + " to exit" + "\n");
        if (in.next().equals(command)) return false;
        else return true;
    }

}
