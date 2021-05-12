package pontus;

import java.io.FileInputStream;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javafx.scene.image.Image;

public class LoginController {

	@FXML	private AnchorPane ap;
	@FXML	private TextField userName;
	@FXML	private PasswordField pass;
	@FXML	private Label invalidLabel;
	@FXML	private Button register;
	@FXML	private Label close;

	@FXML
	public void handleCloseButton(MouseEvent event) {
		Stage stage = (Stage) ap.getScene().getWindow();
		stage.close();
	}

	public void changeScene(ActionEvent event, String fxml) throws IOException {
		Parent dashboard = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxml)));
		Scene dashboardScene = new Scene(dashboard);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.getIcons().add(new Image(new FileInputStream("src\\main\\resources\\Képek\\bejelentkező.jpg")));
		window.setScene(dashboardScene);
                window.setTitle("Pontus");
		window.show();
	}

	@FXML private ImageView loginIcon;
	public Admin activeAdmin;
	public Customer activeCustomer;
	public void handleLoginButton(ActionEvent event) throws Exception {
		//loginIcon.setVisible(true);
		String userName = this.userName.getText();
		String pass = this.pass.getText();
		List<Customer> all_customers = new ArrayList<>();
		List<Admin> all_admins = new ArrayList<>();

		try (CustomerDAO cDAO= new JpaCustomerDAO();
			 AdminDAO aDAO = new JpaAdminDAO();) {
			all_customers = cDAO.getCustomersAll();
			all_admins = aDAO.getAdminsAll();

			for (Admin admin :all_admins){
				if(admin.getUserName().equals(userName)&& admin.getPassword().equals(pass)){//jo admin
					invalidLabel.setVisible(false);
					activeAdmin = aDAO.getAdminbyID(admin.getId());
					AdminDashboardController.getActiveAdmin(activeAdmin);
					changeScene(event,"/fxml/AdminDashboard.fxml");
				}
			}//admin
			for (Customer customer :all_customers){
				if(customer.getUserName().equals(userName)&& customer.getPassword().equals(pass)){//jo user
					invalidLabel.setVisible(false);
					activeCustomer = cDAO.getCustomerbyID(customer.getId());
					CustomerDashboardController.getActiveCustomer(activeCustomer);
					changeScene(event,"/fxml/CustomerDashboard.fxml");
				}
				else {
					invalidLabel.setVisible(true);
				}
			}//cust
		}//try
	}



	@FXML
	public void handleRegisterButton(ActionEvent event) throws IOException {
		Parent register = FXMLLoader.load(getClass().getResource("/fxml/Register.fxml"));
		Scene registerScene = new Scene(register);
		Stage window = new Stage();
                window.getIcons().add(new Image(new FileInputStream("src\\main\\resources\\Képek\\bejelentkező.jpg")));
		window.setScene(registerScene);
		window.setTitle("Regisztráció");
		//window.getIcons().add(new Image("pontus/Image/logo.jpg"));
		window.show();
	}

	@FXML
	public 	void onEnter(ActionEvent event) throws Exception {
		handleLoginButton(event);
	}

}
