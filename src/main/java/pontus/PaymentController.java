package pontus;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PaymentController{

	ProductDAO pDAO = new JpaProductDAO();

	@FXML private TextField cardName;
	@FXML private TextField cardNumber;
	@FXML private TextField cvc;
	@FXML private TextField exp;

	@FXML
	private TableView<Product> cartTable;

	@FXML
	private TableColumn<Product, String> itemCol;

	@FXML
	private TableColumn<Product, String> sizeCol;

	@FXML
	private TableColumn<Product, String> priceCol;

	@FXML
	private TableColumn<Product, String> categoryCol;


	@FXML private Label totalLabel;
	@FXML private Label invalid;

	public static List<Product> cart;
	public static void getActiveCart(List<Product> carts) {
		cart = carts;
	}


	public boolean validateCard() {
		String cardRegx = "\\d{13,16}";
		String cvcReg = "\\d{3}";
		String expReg = ".{4}";
		return !cardNumber.getText().isEmpty() && cardNumber.getText().matches(cardRegx) && cvc.getText().matches(cvcReg) && exp.getText().matches(expReg);
	}

	public void handleConfirmButton(ActionEvent event) throws IOException {
		if(validateCard()){
			invalid.setVisible(false);
			deleteFromDatabase(cart);

			Alert alert = new Alert(Alert.AlertType.INFORMATION,"Sikeres vásárlás!\nKöszönjük hogy a Pontus-t választotta.");
			alert.showAndWait();
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();


			App.stopDatabase();
			Platform.exit();
			System.exit(0);

		}else {
			invalid.setVisible(true);
		}


	}

	private void deleteFromDatabase(List<Product> cart) {
		List<Product> toDelete = new ArrayList<>();
		for(Product product: cart) {
			toDelete.add(pDAO.getProductbyID(product.getId()));
		}
		for(Product product: toDelete) {
			pDAO.deleteProduct(product);
		}
	}

	public float cartSum(List<Product> products) {
		float sum = 0;
		for(Product prod: products) {
			sum += Float.parseFloat(prod.getPrice().toString());
		}
		return sum;
	}
	public void setTable(){


		itemCol.setCellValueFactory(new PropertyValueFactory<>("name"));
		priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
		sizeCol.setCellValueFactory(new PropertyValueFactory<>("size"));
		categoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));
		cartTable.setItems(FXCollections.observableArrayList(cart));
	}

	public void initialize(){
		setTable();
		totalLabel.setText(cartSum(cart) + "Ft");

	}

}
