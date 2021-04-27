package com.mycompany.mavenproject4;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class LoginController {

    @FXML
    private AnchorPane ap;

    @FXML
    private TextField userName;

    @FXML
    private PasswordField pass;

    @FXML
    private Label invalidLabel;

    @FXML
    private Button register;

    @FXML
    private Label close;

    @FXML
    void handleCloseButton(MouseEvent event) {

    }

    @FXML
    void handleLoginButton(ActionEvent event) throws IOException {
        Application.setRoot("CostumerDashborad");
    }

    @FXML
    void handleRegisterButton(ActionEvent event) throws IOException {
        Application.setRoot("Register");
    }

    @FXML
    void onEnter(ActionEvent event) {

    }
}
