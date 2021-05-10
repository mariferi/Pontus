package pontus;

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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class CustomerDashboardController {


	CustomerDAO cDAO= new JpaCustomerDAO();
	ProductDAO pDAO= new JpaProductDAO();

	private static Customer activeCustomer;
	@FXML
	private AnchorPane enquiry;

	@FXML
	private Label customerName;

	@FXML
	private Button store_btn;

	@FXML
	private Button history_btn;

	@FXML
	private Button enquiry_btn;

	@FXML
	private Button account_btn;

	@FXML
	private AnchorPane enquiry_pane;

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
	private ChoiceBox<String> productNameChoice;

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

	public static void getActiveCustomer(Customer customer) {
		activeCustomer = customer;
	}

	public void initialize() {
		customerName.setText(activeCustomer.getUserName());
		modifyNameLabel.setText(activeCustomer.getUserName());
		modifyEmailLabel.setText(activeCustomer.getUserEmail());
		modifyAddressLabel.setText(activeCustomer.getAddress());
		customerIDLabel.setText(String.valueOf(activeCustomer.getId()));
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



	private Cart cart = new Cart();
	public void handleAddToCart(){
/*
		checkoutBtn.setDisable(false);
		removeBtn.setDisable(false);
		List<Product> inventory = Product.getListFromDB();
		for (Product p:inventory) {
			if (productNameChoice.getValue().equals(p.getName()) && productSizeChoice.getValue().equals(p.getSize())) {
				int qty = (productQty.getValue());
				Purchase item = new Purchase(p, qty);
				Cart.addToCartList(item);
			}
		}
		totalLabel.setText(""+cart.getCartTotal());
		//setTable();

 */
	}

	public void handleRemoveButton(){

		if(cartTable.getSelectionModel().getSelectedItem()==null){
			return;
		}
		cart.removeFromCart(cartTable.getSelectionModel().getSelectedIndex());
		//setTable();
		totalLabel.setText(""+cart.getCartTotal());
		if(cart.getCartTotal().equals(new BigDecimal("0"))){
			checkoutBtn.setDisable(true);
			removeBtn.setDisable(true);
		}

	}

	public void handleCheckout() throws IOException {
/*
		total=totalLabel.getText();
		cart.setPrice(total);
		cart.setDate(cart.getDate());
		cart.setId("00"+ Customer.getCustomer().getId());
		cart.setCartName(""+Customer.getCustomer().getId());
		cart.checkout();
*/
		Parent dashboard = FXMLLoader.load(getClass().getResource("/fxml/Payment.fxml"));
		Scene checkout = new Scene(dashboard);
		Stage window = new Stage();
		window.setScene(checkout);
		window.setTitle("Confirm Payment");
		window.show();


	}

	public void handleUpdateDetailsButton(){
	}
	public void setAccountPane(){
		/*
		customerIDLabel.setText(Customer.getCustomer().getId()+"");
		modifyName.setText(Customer.getCustomer().getName());
		modifyAddress.setText(Customer.getCustomer().getAddress());
		modifyEmail.setText(Customer.getCustomer().getUserName());
		modifyNameLabel.setText(modifyName.getText());
		modifyEmailLabel.setText(Customer.getCustomer().getUserName());
		modifyAddressLabel.setText(modifyAddress.getText());
*/
	}

	public void modifyAccount(){
		/*
		String name = modifyName.getText();
		String address = modifyAddress.getText();
		String email = modifyEmail.getText();
		String id = Customer.getCustomer().getId().toString();
		String qry =  "UPDATE customer SET name = '"+name+"', address = '"+address+"' WHERE id = '"+id+"';";
		Application.executeQueryforUpdate(qry);
		modifyNameLabel.setText(modifyName.getText());
		modifyEmailLabel.setText(Customer.getCustomer().getUserName());
		modifyAddressLabel.setText(modifyAddress.getText());
*/

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

	public void handleImg1(){
		mainImg.setImage( new Image("resources/Képek/pc.jpg"));
		productNameChoice.setValue("Számítógép");


	}
	public void handleImg2(){
		mainImg.setImage( new Image("resources/Képek/tv.jpg"));
		productNameChoice.setValue("Televizió");

	}
	public void handleImg3(){
		mainImg.setImage( new Image("resources/Képek/laptop.jpg"));
		productNameChoice.setValue("Laptop");
	}
	public void handleImg4(){
		mainImg.setImage( new Image("resources/Képek/mosógép.jpg"));
		productNameChoice.setValue("Mosógépek");

	}
	public void handleImg5(){
		mainImg.setImage( new Image("resources/Képek/mikró.jpg"));
		productNameChoice.setValue("Mikrohullámos sütők");
	}
	public void handleImg6(){
		mainImg.setImage( new Image("resources/Képek/porsziv.jpg"));
		productNameChoice.setValue("Porszivók");

	}
	public void handleImg7(){
		mainImg.setImage( new Image("resources/Képek/rádió.jpg"));
		productNameChoice.setValue("Radiók,Hifitornyok");

	}    public void handleImg8(){;
		mainImg.setImage( new Image("resources/Képek/hűtő.jpg"));
		productNameChoice.setValue("Hűtőszekrények");
	}    public void handleImg9(){
		//   mainImg.setImage( new Image("Store/productPics/9.jpg"));

	}
	public void handleHomeLink(ActionEvent event) throws IOException {

		Parent register = FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));
		Scene registerScene = new Scene(register);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(registerScene);
		window.show();
	}


}
