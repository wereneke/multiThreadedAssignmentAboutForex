package com.werkasowa.fx.controller;

import com.werkasowa.fx.runnable.Listener;
import com.werkasowa.fx.runnable.Printer;
import com.werkasowa.fx.runnable.TickContainer;
import org.springframework.stereotype.Component;

@Component
public class Controller {

    Listener listener;
    Printer printer;
    TickContainer tickContainer;

    Thread listeningThread;
    Thread printingThread;
    Thread tickingThread;

    boolean running;

    public Controller(Listener listener, Printer printer, TickContainer tickContainer) {
        this.listener = listener;
        this.printer = printer;
        this.tickContainer = tickContainer;
        this.running = true;
    }


    public void startComponents() {
        listeningThread = new Thread(listener);
        printingThread = new Thread(printer);
        tickingThread = new Thread(tickContainer);

        listeningThread.start();
        printingThread.start();
        tickingThread.start();
    }

    public void exitProgram() {
        listeningThread.interrupt();
        printingThread.interrupt();
        tickingThread.interrupt();
    }

    private void handleInput(String input) {

        if (input.equals(".quit")) {
            exitProgram();
            this.running = false;
        }
        if (!tickContainer.getPairs().contains(input)) {
            tickContainer.addPair(input);
        }

    }

    public void run() {

        startComponents();

        while (running) {
            handleInput(listener.getInput());
            printer.setTicks(tickContainer.getTicks());
        }
    }
}
