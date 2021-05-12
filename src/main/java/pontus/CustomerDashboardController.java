package pontus;

import java.io.FileInputStream;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.input.MouseEvent;


public class CustomerDashboardController {

	List<Product> cart = new ArrayList<>();

	CustomerDAO cDAO= new JpaCustomerDAO();
	ProductDAO pDAO= new JpaProductDAO();

	private static Customer activeCustomer;
	@FXML	private Label customerName;
	@FXML	private Button store_btn;
	@FXML	private Button account_btn;
	@FXML	private AnchorPane account_pane;
	@FXML	private PasswordField oldPassword;
	@FXML	private Label modifyNameLabel;
	@FXML	private Label modifyAddressLabel;
	@FXML	private Label customerIDLabel;
	@FXML	private Label modifyEmailLabel;
	@FXML	private PasswordField newPassword;
	@FXML	private AnchorPane store_pane;
	@FXML	private Label totalLabel;
    @FXML 	private TableView<Product> productTableView;
    @FXML 	private TableColumn<Product,String> productNameCol;
    @FXML 	private TableColumn<Product,String> productPriceCol;
    @FXML	private TableColumn<Product,String> productSizeCol;
    @FXML	private TableColumn<Product,String> productCategoryCol;
	@FXML	private TableView<Product> cartTable;
	@FXML	private TableColumn<Product,String> cartItemCol;
	@FXML	private TableColumn<Product,String> cartCategoryCol;
	@FXML	private TableColumn<Product,String> cartPriceCol;

	@FXML
	private Label invalidPasswordLabel;
	@FXML
	private TextField newEmail;
	@FXML
	private Label invalidEmailLabel;
	@FXML
	private TextField newAdressLabel;

	public static void getActiveCustomer(Customer customer) {
		activeCustomer = customer;
	}

	public void initialize() {
		customerName.setText(activeCustomer.getUserName());
		modifyNameLabel.setText(activeCustomer.getUserName());
		modifyEmailLabel.setText(activeCustomer.getUserEmail());
		modifyAddressLabel.setText(activeCustomer.getAddress());
		customerIDLabel.setText(String.valueOf(activeCustomer.getId()));

		refreshProducts();
	}

    public void refreshProducts() {
        List<Product> products = pDAO.getProductsAll();

        productNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        productPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        productSizeCol.setCellValueFactory(new PropertyValueFactory<>("size"));
        productCategoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));
        productTableView.setItems(FXCollections.observableArrayList(products));
    }

    public void refreshProductsByCategory(String category) {
		List<Product> products = pDAO.getProductsbyCategory(category);

		productNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
		productPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
		productSizeCol.setCellValueFactory(new PropertyValueFactory<>("size"));
		productCategoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));
		productTableView.setItems(FXCollections.observableArrayList(products));
	}

	public void handleTabButtons(ActionEvent event) {
		if (event.getSource() == store_btn) {
			store_pane.toFront();
		} else if (event.getSource() == account_btn) {
			initialize();
			account_pane.toFront();
		}
	}
    @FXML
    void handlehutokep(MouseEvent event) {
        refreshProductsByCategory("Hűtőszekrények");
    }

    @FXML
    void handlelaptopkep(MouseEvent event) {
        refreshProductsByCategory("Laptopok");
    }

    @FXML
    void handlemikrokep(MouseEvent event) {
		refreshProductsByCategory("Mikrohullámos sütők");
    }

    @FXML
    void handlemosogepkep(MouseEvent event) {
		refreshProductsByCategory("Mosógépek");
    }

    @FXML
    void handlepckep(MouseEvent event) {
		refreshProductsByCategory("Számítógépek");
    }

    @FXML
    void handleporszivokep(MouseEvent event) {
		refreshProductsByCategory("Porszivók");
    }

    @FXML
    void handleradiokep(MouseEvent event) {
		refreshProductsByCategory("Rádiók,Hifitornyok");
    }

    @FXML
    void handletvkep(MouseEvent event) {
		refreshProductsByCategory("Televiziók");
    }



	public void handleAddToCart(){
		Product product = productTableView.getSelectionModel().getSelectedItem();
		cart.add(product);
		productTableView.getItems().remove(product);
		cartTable(cart);
		totalLabel.setText(cartSum(cart) + " Ft");
	}

	public float cartSum(List<Product> products) {
		float sum = 0;
		for(Product prod: products) {
			sum += Float.parseFloat(prod.getPrice().toString());
		}
		return sum;
	}

	public void cartTable(List<Product> products) {
		cartItemCol.setCellValueFactory(new PropertyValueFactory<>("name"));
		cartPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
		cartCategoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));
		cartTable.setItems(FXCollections.observableArrayList(products));
	}

	public void handleRemoveButton(){
		Product product = cartTable.getSelectionModel().getSelectedItem();
		cartTable.getItems().remove(product);
		cart.remove(product);
		totalLabel.setText(cartSum(cart) + "");
		refreshProductsByCategory(product.getCategory());
	}

	public void handleCheckout() throws IOException {
		if (!cart.isEmpty()) {
			PaymentController.getActiveCart(cart);
			Parent dashboard = FXMLLoader.load(getClass().getResource("/fxml/Payment.fxml"));
			Scene checkout = new Scene(dashboard);
			Stage window = new Stage();
			window.getIcons().add(new Image(new FileInputStream("src\\main\\resources\\Képek\\bejelentkező.jpg")));
			window.setScene(checkout);
			window.setTitle("Fizetés ellenőrzés");
			window.show();
		}
	}


	public void changePassword() throws Exception {
		invalidEmailLabel.setVisible(false);
		invalidPasswordLabel.setVisible(false);
		String oldPassField = oldPassword.getText();
		String newPassField = newPassword.getText();
		String oldPassAct = activeCustomer.getPassword();
		if (oldPassField.equals(oldPassAct)) {
			try (CustomerDAO cDAO = new JpaCustomerDAO();) {
				if (!newPassword.getText().isEmpty()) {
					if (Customer.validatePassword(newPassField)) {
						invalidPasswordLabel.setVisible(false);

						Customer customer = cDAO.getCustomerbyID(activeCustomer.getId());
						customer.setPassword(newPassField);
						cDAO.updateCustomer(customer);
						Alert alert = new Alert(Alert.AlertType.INFORMATION, "Sikeres jelszó változtatás!");
						alert.showAndWait();
					}
				 	else {
						Alert alert = new Alert(Alert.AlertType.ERROR,
								" • A Jelszóban legalább 8 karakter valamint 2db szám vagy\nbármilyen nem betű karakternek is lennie kell!");
						alert.showAndWait();
					}
				}
				if (!newEmail.getText().isEmpty()) {
					if (Customer.validateEmail(newEmail.getText())) {
						invalidEmailLabel.setVisible(false);
						Customer customer = cDAO.getCustomerbyID(activeCustomer.getId());
						customer.setUserEmail(newEmail.getText());
						cDAO.updateCustomer(customer);
						Alert alert = new Alert(Alert.AlertType.INFORMATION, "Sikeres email változtatás!");
						alert.showAndWait();
					}
					else {
						invalidEmailLabel.setVisible(true);
					}
				}
				if (!newAdressLabel.getText().isEmpty()) {
					Customer customer = cDAO.getCustomerbyID(activeCustomer.getId());
					customer.setAddress(newAdressLabel.getText());
					cDAO.updateCustomer(customer);
					Alert alert = new Alert(Alert.AlertType.INFORMATION, "A cím sikeresen megváltoztatva!");
					alert.showAndWait();
				}
			}
		}
		else {
			invalidPasswordLabel.setVisible(true);
		}
	}


	public void handleHomeLink(ActionEvent event) throws IOException {
		Parent register = FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));
		Scene registerScene = new Scene(register);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(registerScene);
		window.show();
	}


}
