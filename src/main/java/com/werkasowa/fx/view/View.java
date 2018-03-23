package com.werkasowa.fx.view;

import com.werkasowa.fx.tick.DeserializeTicks;

public class View {

    public void printQuotes(String json) {

        System.out.println(new DeserializeTicks().readJson(json));
        System.out.println("Press 'Enter' to enter the menu");
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
