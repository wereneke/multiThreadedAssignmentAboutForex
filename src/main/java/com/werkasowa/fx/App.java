package com.werkasowa.fx;

import com.werkasowa.fx.view.View;

public class App {

    View view = new View();
    public static void main(String[] args) {

        App app = new App();
        boolean run = true;
        while (run) {
            app.view.run();


        }
    }

}
