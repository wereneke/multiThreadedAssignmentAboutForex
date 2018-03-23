package com.werkasowa.fx.controller;

import com.werkasowa.fx.runnable.Listener;
import com.werkasowa.fx.runnable.Printer;

public class Controller {

    public void startApp() {

        Thread tPr = new Thread(new Printer());
        tPr.start();

        Thread tLi = new Thread(new Listener());
        tLi.start();

    }
}
