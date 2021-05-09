package pontus;

import javafx.collections.FXCollections;
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
import java.util.ArrayList;
import java.util.List;


public class AdminDashboardController {

	CustomerDAO cDAO= new JpaCustomerDAO();
	AdminDAO aDAO = new JpaAdminDAO();

	@FXML private TextField customerID;

	@FXML private Label usernameLabel;
	@FXML private TableView<Customer> customerTableView;
	@FXML private TableView<Product> productTableView;
	@FXML private TableView<Admin> AdminTableView;

	@FXML private TableColumn<Product,String> productIdCol;
	@FXML private TableColumn<Product,String> productCodeCol;
	@FXML private TableColumn<Product,String> productNameCol;
	@FXML private TableColumn<Product,String> productPriceCol;
	@FXML private TableColumn<Product,String> productSizeCol;
	@FXML private TextField productName;
	@FXML private TextField productCode;
	@FXML private TextField productSize;
	@FXML private TextField productPrice;


	@FXML
	private TableColumn<?, ?> customerIdCol;

	@FXML
	private TableColumn<?, ?> customerEmailCol;

	@FXML
	private TableColumn<?, ?> customerAddCol;

	@FXML
	private TableColumn<?, ?> customerUserNameCol;

	@FXML
	private TableColumn<?, ?> customerPassCol;

	@FXML
	private TableColumn<?, ?> AdminIdCol;

	@FXML
	private TableColumn<?, ?> AdminUserNameCol;

	@FXML
	private TableColumn<?, ?> AdminPassCol;



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
		Parent register = FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));
		Scene registerScene = new Scene(register);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(registerScene);
		window.show();
	}

	public void initialize() throws Exception {

	}

	private void initializeTables() throws Exception {


			/*
		}
/*

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

 */

		}

	@FXML
	void handleAddAdminButton(ActionEvent event) {

	}

	@FXML
	void handleDeleteAdminButton(ActionEvent event) {

	}
	@FXML
	void refreshAdmin(ActionEvent event) {
		List<Admin> adminList = new ArrayList<>();
		adminList = aDAO.getAdminsAll();

		AdminIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
		AdminUserNameCol.setCellValueFactory(new PropertyValueFactory<>("userName"));
		AdminPassCol.setCellValueFactory(new PropertyValueFactory<>("password"));
		AdminTableView.setItems(FXCollections.observableArrayList(adminList));

	}



	@FXML
	void deleteCustomer(ActionEvent event) throws Exception {

			Customer customer = customerTableView.getSelectionModel().getSelectedItem();
			customerTableView.getItems().remove(customer);
			cDAO.deleteCustomer(customer);
	}

	@FXML
	void refreshCustormers(ActionEvent event) {
		List<Customer> customers = new ArrayList<>();
		customers = cDAO.getCustomersAll();

		customerAddCol.setCellValueFactory(new PropertyValueFactory<>("address"));
		customerEmailCol.setCellValueFactory(new PropertyValueFactory<>("userEmail"));
		customerUserNameCol.setCellValueFactory(new PropertyValueFactory<>("userName"));
		customerPassCol.setCellValueFactory(new PropertyValueFactory<>("password"));
		customerIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
		customerTableView.setItems(FXCollections.observableArrayList(customers));
	}

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
