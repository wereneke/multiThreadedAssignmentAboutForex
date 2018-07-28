package com.werkasowa.fx.controller;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import org.springframework.stereotype.Component;

@Component
public class FxController {

    @FXML
    private Text actiontarget;

    public void handleSubmitButtonAction() {
        System.out.println("wszystko pod kontrolą");
        actiontarget.setText("jusz");
    }
}
