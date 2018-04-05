package com.werkasowa.fx;

import com.werkasowa.fx.runnable.Listener;
import com.werkasowa.fx.runnable.Printer;
import com.werkasowa.fx.runnable.TickContainer;

public class Controller implements Runnable {

    private Printer printer;
    private Listener listener;
    private Thread listeningThread;
    private TickContainer tickContainer;


    public Controller() {

        this.printer = new Printer();
        this.listener = new Listener();
        this.listeningThread = new Thread(listener);

        this.tickContainer = new TickContainer();
    }

    private void handleInput(String input) {

        if (input.equals(".quit")) {
            //code for closing app
        }
        if (input.startsWith("rm")) {
            String tickName = input.substring(3,9);

            // remove tickname from getting it from internet
        }
        if (input.length()==6) {

            //add input to geter from interneter
        }


    }

    @Override
    public void run() {
        printer.comunicate("Hello, enter currency signature to get actual prices");
        String tickSignature = listener.getLastOrder();
        //wait&notify
        tickContainer.addPair(tickSignature);
        Thread ticking = new Thread(tickContainer);
        ticking.start();
        while (true) {
            printer.printTicks(tickContainer);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
