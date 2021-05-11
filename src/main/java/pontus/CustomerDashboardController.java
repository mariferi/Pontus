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
	@FXML private AnchorPane enquiry;
	@FXML	private Label customerName;
	@FXML	private Button store_btn;
	@FXML	private Button history_btn;
	@FXML	private Button enquiry_btn;
	@FXML	private Button account_btn;
	@FXML	private AnchorPane enquiry_pane;
	@FXML	private TextArea enquiryMessage;
	@FXML	private AnchorPane account_pane;
	@FXML	private TextField modifyName;
	@FXML	private TextArea modifyAddress;
	@FXML	private PasswordField oldPassword;
	@FXML	private Label modifyNameLabel;
	@FXML	private Label modifyAddressLabel;
	@FXML	private Label customerIDLabel;
	@FXML	private Label modifyEmailLabel;
	@FXML	private PasswordField newPassword;
	@FXML	private AnchorPane history_pane;
	@FXML	private TableView<?> purchaseHistory;
	@FXML	private TableColumn<?, ?> purchaseIdCol;
	@FXML	private TableColumn<?, ?> purchaseDayCol;
	@FXML	private TableColumn<?, ?> purchaseAmountCol;
	@FXML	private AnchorPane store_pane;
	@FXML	private Spinner<?> productQty;
	@FXML	private ImageView mainImg;
	@FXML	private ChoiceBox<String> productNameChoice;
	@FXML	private ChoiceBox<?> productSizeChoice;
	@FXML	private TableColumn<?, ?> itemCol;
	@FXML	private TableColumn<?, ?> qtyCol;
	@FXML	private TableColumn<?, ?> costCol;
	@FXML	private TableColumn<?, ?> amountCol;
	@FXML	private Label totalLabel;
	@FXML	private Button checkoutBtn;
	@FXML	private Button removeBtn;
	@FXML	private ImageView img1;

    @FXML private TableView<Product> productTableView;

    @FXML private TableColumn<Product,String> productIdCol;
    @FXML private TableColumn<Product,String> productCodeCol;
    @FXML private TableColumn<Product,String> productNameCol;
    @FXML private TableColumn<Product,String> productPriceCol;
    @FXML private TableColumn<Product,String> productSizeCol;
    @FXML private TableColumn<Product,String> productCategoryCol;

	@FXML
	private TableView<Product> cartTable;

	@FXML
	private TableColumn<Product,String> cartItemCol;

	@FXML
	private TableColumn<Product,String> cartCategoryCol;

	@FXML
	private TableColumn<Product,String> cartPriceCol;

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
		} else if (event.getSource() == history_btn) {
			history_pane.toFront();
		} else if (event.getSource() == account_btn) {
			account_pane.toFront();
		} else if (event.getSource() == enquiry_btn) {
			enquiry_pane.toFront();
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

/*
	public void setTable(){


		itemCol.setCellValueFactory(new PropertyValueFactory<>("name"));
		qtyCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
		costCol.setCellValueFactory(new PropertyValueFactory<>("price"));
		amountCol.setCellValueFactory(new PropertyValueFactory<>("purchaseAmount"));
		cartTable.setItems(Cart.getCartList());


		ObservableList hist = Purchase.getListFromDB(Customer.getCustomer().getId()+"");
		purchaseDayCol.setCellValueFactory(new PropertyValueFactory<>("date"));
		purchaseIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
		purchaseAmountCol.setCellValueFactory(new PropertyValueFactory<>("price"));
		purchaseHistory.setItems(Purchase.getListFromDB(Customer.getCustomer().getId()+""));
	}

	public void initialize(){
		setTable();

		removeBtn.setDisable(true);
		checkoutBtn.setDisable(true);
		getItems();
		setAccountPane();
		username.setText(Account.getUser());
		productNameChoice.setValue(productNameChoice.getItems().get(2));
		productSizeChoice.setValue(productSizeChoice.getItems().get(1));
		SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
		productQty.setValueFactory(valueFactory);
	}
*/
	private void getItems(){
		/*
		List<String> list = new ArrayList<>();
		List<Product> l = Product.getListFromDB();
		for (Product p : l) {
			list.add(p.getName());//adding  product object to list
		}

		HashSet<String> nameList = new HashSet<>(list); //using hashset to filter duplicated products
		productNameChoice.getItems().addAll(nameList);  //adding all the items to combobox

		//Listening for changes and changing the list to new values
		productNameChoice.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue)->{
			getItemChoice(productNameChoice);
		});
*/
	}



	public void getItemChoice(ChoiceBox<String> productNameChoice) {
		/*
		String name = productNameChoice.getValue();
		List<Product> productList = Product.getListFromDB();

		for (Product p : productList) {
			productSizeChoice.getItems().removeAll(p.getSize());
			if (p.getName().equals(name)) {
				productSizeChoice.getItems().add(p.getSize());
			}
		}
*/
	}

	public void handleAddToCart(){
		Product product = productTableView.getSelectionModel().getSelectedItem();
		cart.add(product);
		productTableView.getItems().remove(product);
		cartTable(cart);
		totalLabel.setText(cartSum(cart) + "Ft");
	}

	public float cartSum(List<Product> products) {
		float sum = 0;
		for(Product prod: products) {
			sum += Float.parseFloat(prod.getPrice().toString());
		}
		return sum;
	}

	public void cartTable(List<Product> selectedProduct) {
		//List<Product> products = selectedProduct;

		cartItemCol.setCellValueFactory(new PropertyValueFactory<>("name"));
		cartPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
		cartCategoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));
		cartTable.setItems(FXCollections.observableArrayList(selectedProduct));
	}

	public void handleRemoveButton(){
		Product product = cartTable.getSelectionModel().getSelectedItem();
		cartTable.getItems().remove(product);
		cart.remove(product);
		totalLabel.setText(cartSum(cart) + "");
		refreshProductsByCategory(product.getCategory());
	}

	public void handleCheckout() throws IOException {
		PaymentController.getActiveCart(cart);

		Parent dashboard = FXMLLoader.load(getClass().getResource("/fxml/Payment.fxml"));
		Scene checkout = new Scene(dashboard);
		Stage window = new Stage();
                window.getIcons().add(new Image(new FileInputStream("src\\main\\resources\\Képek\\bejelentkező.jpg")));
		window.setScene(checkout);
		window.setTitle("Fizetés ellenőrzés");
		window.show();

	}


	public void changePassword() throws Exception {
		String oldPassField = oldPassword.getText();
		String newPassField = newPassword.getText();
		String oldPassAct = activeCustomer.getPassword();
		if (oldPassField.equals(oldPassAct)) {
			try(CustomerDAO cDAO= new JpaCustomerDAO();){
				Customer customer = cDAO.getCustomerbyID(activeCustomer.getId());
				customer.setPassword(newPassField);
				cDAO.updateCustomer(customer);
			}
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
