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
	ProductDAO pDAO = new JpaProductDAO();

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
	@FXML private TableColumn<Product,String> productCategoryCol;
	@FXML private TextField productName;
	@FXML private TextField productCode;
	@FXML private TextField productSize;
	@FXML private TextField productPrice;

	@FXML private TableColumn<?, ?> customerIdCol;
	@FXML private TableColumn<?, ?> customerEmailCol;
	@FXML private TableColumn<?, ?> customerAddCol;
	@FXML private TableColumn<?, ?> customerUserNameCol;
	@FXML private TableColumn<?, ?> customerPassCol;
	@FXML private TableColumn<?, ?> AdminIdCol;
	@FXML private TableColumn<?, ?> AdminUserNameCol;
	@FXML private TableColumn<?, ?> AdminPassCol;
	@FXML private TextField addUserText;
	@FXML private TextField addPassText;


	@FXML private  Tab customerTab;
	@FXML private  Tab productsTab;
	@FXML private  Tab staffTab;
	@FXML private ComboBox KategóriaBox;

	ObservableList<String> KategóriaList=FXCollections.observableArrayList("Számítógépek","Televiziók","Laptopok","Mosógépek","Mikrohullámos sütők",
                "Porszivók","Rádiók,Hifitornyok","Hűtőszekrények");

	public void initialize(){
		KategóriaBox.setValue("Kategória");
		KategóriaBox.setItems(KategóriaList);
	}


	public void handleHomeButton(ActionEvent event) throws IOException {
		Parent register = FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));
		Scene registerScene = new Scene(register);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(registerScene);
		window.show();
	}


	@FXML
	void handleAddAdminButton(ActionEvent event) {
		Admin admin = new Admin(addUserText.getText(), addPassText.getText());
		aDAO.saveAdmin(admin);
		refreshAdmin(event);
	}

	@FXML
	void handleDeleteAdminButton(ActionEvent event) {
		Admin admin = AdminTableView.getSelectionModel().getSelectedItem();
		AdminTableView.getItems().remove(admin);
		aDAO.deleteAdmin(admin);
	}
	@FXML
	void refreshAdmin(ActionEvent event) {
		List<Admin> adminList = aDAO.getAdminsAll();

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
		List<Customer> customers = cDAO.getCustomersAll();
                
		customerAddCol.setCellValueFactory(new PropertyValueFactory<>("address"));
		customerEmailCol.setCellValueFactory(new PropertyValueFactory<>("userEmail"));
		customerUserNameCol.setCellValueFactory(new PropertyValueFactory<>("userName"));
		customerPassCol.setCellValueFactory(new PropertyValueFactory<>("password"));
		customerIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
		customerTableView.setItems(FXCollections.observableArrayList(customers));
	}

	public void handleProductDelButton(){
		Product product = productTableView.getSelectionModel().getSelectedItem();
		productTableView.getItems().remove(product);
		pDAO.deleteProduct(product);
		handleProductUpdateButton();
	}

	public void handleProductUpdateButton(){
		List<Product> products = pDAO.getProductsAll();
                
		productCodeCol.setCellValueFactory(new PropertyValueFactory<>("code"));
		productIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
		productNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
		productPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
		productSizeCol.setCellValueFactory(new PropertyValueFactory<>("size"));
		productCategoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));
		productTableView.setItems(FXCollections.observableArrayList(products));

	}
	public String choosenCategory() {
		return KategóriaBox.getSelectionModel().getSelectedItem().toString();
	}

	public void handleProductAddButton(){

		Product product = new Product(productCode.getText(), productName.getText(), productSize.getText(),
				choosenCategory(), new BigDecimal(Integer.parseInt(productPrice.getText())));

		pDAO.saveProduct(product);
		handleProductUpdateButton();

	}

}
