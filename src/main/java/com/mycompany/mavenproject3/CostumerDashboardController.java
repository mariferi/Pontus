/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author nkalm
 */
public class CostumerDashboardController {
   

    @FXML
    private AnchorPane enquiry_pane;

    @FXML
    private Label username;

    @FXML
    private Button store_btn;

    @FXML
    private Button history_btn;

    @FXML
    private Button enquiry_btn;

    @FXML
    private Button account_btn;

    @FXML
    private TextArea enquiryMessage;

    @FXML
    private AnchorPane account_pane;

    @FXML
    private TextField modifyName;

    @FXML
    private TextArea modifyAddress;

    @FXML
    private PasswordField oldPassword;

    @FXML
    private Label modifyNameLabel;

    @FXML
    private TextField modifyEmail;

    @FXML
    private Label modifyAddressLabel;

    @FXML
    private Label customerIDLabel;

    @FXML
    private Label modifyEmailLabel;

    @FXML
    private PasswordField newPassword;

    @FXML
    private AnchorPane history_pane;

    @FXML
    private TableView<?> purchaseHistory;

    @FXML
    private TableColumn<?, ?> purchaseIdCol;

    @FXML
    private TableColumn<?, ?> purchaseDayCol;

    @FXML
    private TableColumn<?, ?> purchaseAmountCol;

    @FXML
    private AnchorPane store_pane;

    @FXML
    private Spinner<?> productQty;

    @FXML
    private ImageView mainImg;

    @FXML
    private ChoiceBox<?> productNameChoice;

    @FXML
    private ChoiceBox<?> productSizeChoice;

    @FXML
    private TableView<?> cartTable;

    @FXML
    private TableColumn<?, ?> itemCol;

    @FXML
    private TableColumn<?, ?> qtyCol;

    @FXML
    private TableColumn<?, ?> costCol;

    @FXML
    private TableColumn<?, ?> amountCol;

    @FXML
    private Label totalLabel;

    @FXML
    private Button checkoutBtn;

    @FXML
    private Button removeBtn;

    @FXML
    private ImageView img1;

    @FXML
    void changePassword(ActionEvent event) {

    }

    @FXML
    void handleAddToCart(ActionEvent event) {

    }

    @FXML
    void handleCheckout(ActionEvent event) {

    }

    @FXML
    void handleEnquiryButton(ActionEvent event) {

    }

    @FXML
    void handleHomeLink(ActionEvent event) {

    }

    @FXML
    void handleImg1(MouseEvent event) {

    }

    @FXML
    void handleImg2(MouseEvent event) {

    }

    @FXML
    void handleImg3(MouseEvent event) {

    }

    @FXML
    void handleImg4(MouseEvent event) {

    }

    @FXML
    void handleImg5(MouseEvent event) {

    }

    @FXML
    void handleImg6(MouseEvent event) {

    }

    @FXML
    void handleImg7(MouseEvent event) {

    }

    @FXML
    void handleImg8(MouseEvent event) {

    }

    @FXML
    void handleImg9(MouseEvent event) {

    }

    @FXML
    void handleRemoveButton(ActionEvent event) {

    }

    @FXML
    void handleTabButtons(ActionEvent event) {

    }

    @FXML
    void modifyAccount(ActionEvent event) {

    }

    
}
