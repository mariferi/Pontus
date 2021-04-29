package com.mycompany.mavenproject4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class RegisterController {

    @FXML
    private TextField name;

    @FXML
    private TextField userName;

    @FXML
    private TextArea address;

    @FXML
    private PasswordField password;

    @FXML
    private PasswordField verifyPassword;

    @FXML
    private CheckBox policy;

    @FXML
    private Label invalidName;

    @FXML
    private Label invalidEmail;

    @FXML
    private Label invalidAddress;

    @FXML
    private Label invalidPassword;

    @FXML
    private Label invalidMatch;

    @FXML
    void handleAddButton(ActionEvent event) {

    }

}

