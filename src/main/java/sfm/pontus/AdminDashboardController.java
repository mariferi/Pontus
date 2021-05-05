package sfm.pontus;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class AdminDashboardController {

	@FXML private TextField customerID;

	@FXML private Label usernameLabel;
	@FXML private TableView<Customer> customerTableView;
	@FXML private TableView<Product> productTableView;

	@FXML private TableColumn<Product,String> productIdCol;
	@FXML private TableColumn<Product,String> productCodeCol;
	@FXML private TableColumn<Product,String> productNameCol;
	@FXML private TableColumn<Product,String> productPriceCol;
	@FXML private TableColumn<Product,String> productSizeCol;
	@FXML private TextField productName;
	@FXML private TextField productCode;
	@FXML private TextField productSize;
	@FXML private TextField productPrice;


	@FXML private TableColumn<Cart,String> purchaseIDCol;
	@FXML private TableColumn<Cart,String> purchaseNameCol;
	@FXML private TableColumn<Cart,String> purchasePriceCol;
	@FXML private TableColumn<Cart,String> purchaseDateCol;
	@FXML private TableView<Cart> purchaseTableView;


	@FXML private TextField addUserText;
	@FXML private TextField addPassText;


	@FXML private  Tab customerTab;
	@FXML private  Tab productsTab;
	@FXML private  Tab staffTab;

	@FXML private DatePicker datePicker;
	@FXML private Button viewAll;

	public void handleDatePicker(){
		LocalDate date = datePicker.getValue();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY/MM/dd");
		String day = formatter.format(date);
		customerID.setText(day);
		handleViewTransactionButton();

	}



	public void handleStaffUpdateButton(){

		//staffTableView.setItems(Admin.getStaffListFromDB());
	}
	public void handleHomeButton(ActionEvent event) throws IOException {
		Parent register = FXMLLoader.load(getClass().getResource("Login.fxml"));
		Scene registerScene = new Scene(register);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(registerScene);
		window.show();
	}
	public void handleStaffAddButton(){
		//Admin.addStaff(addUserText.getText(),addPassText.getText());
		addUserText.clear();
		addPassText.clear();
		handleStaffUpdateButton();
	}

	public void initialize(){



	}
/*
	private void initializeTables(){
		staffIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
		staffUserNameCol.setCellValueFactory(new PropertyValueFactory<>("userName"));
		staffPassCol.setCellValueFactory(new PropertyValueFactory<>("password"));
		staffTableView.setItems(Admin.getStaffListFromDB());


		customerAddCol.setCellValueFactory(new PropertyValueFactory<>("address"));
		customerNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
		customerUserNameCol.setCellValueFactory(new PropertyValueFactory<>("userName"));
		customerPassCol.setCellValueFactory(new PropertyValueFactory<>("password"));
		customerIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
		customerTableView.setItems(Customer.getListFromDB());

		purchaseDateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
		purchaseIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
		purchasePriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
		purchaseNameCol.setCellValueFactory(new PropertyValueFactory<>("cartName"));
		purchaseTableView.setItems(Purchase.getListFromDB());


		productCodeCol.setCellValueFactory(new PropertyValueFactory<>("code"));
		productIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
		productNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
		productPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
		productSizeCol.setCellValueFactory(new PropertyValueFactory<>("size"));
		productTableView.setItems(Product.getListFromDB());

	}

 */
	public void handleProductDelButton(){

	}
	public void handleViewTransactionButton(){

		//purchaseTableView.setItems(Staff.viewTransaction(customerID.getText()));
	}

	public void handleViewReport() throws IOException {
		//Admin.viewReport(customerID.getText());
	}
	public void handleProductUpdateButton(){
		//productTableView.setItems(Product.getListFromDB());

	}
	public void handleViewAllButton(){
		//purchaseTableView.setItems(Purchase.getListFromDB("all"));

	}
	public void handleProductAddButton(){
		/*
		Product product = new Product();
		JpaProductDAO productDAO = new JpaProductDAO();
		productDAO.saveProduct(product);
		*/
	}

	public void handleDeleteButton(){

	}
}
