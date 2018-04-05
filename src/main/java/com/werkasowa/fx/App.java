package com.werkasowa.fx;

import com.werkasowa.fx.controller.Controller;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) throws InterruptedException {

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        Controller controller = ctx.getBean(Controller.class);

        controller.run();

    }
}
