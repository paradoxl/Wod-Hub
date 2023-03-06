package com.example.wodhub;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Login_Controller {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}