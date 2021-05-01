package sfm.pontus;

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
import java.util.Objects;

public class LoginController {

	@FXML
	private AnchorPane ap;

	@FXML
	private TextField userName;

	@FXML
	private PasswordField pass;

	@FXML
	private Label invalidLabel;

	@FXML
	private Button register;

	@FXML
	private Label close;

	@FXML
	public void handleCloseButton(MouseEvent event) {
		Stage stage = (Stage) ap.getScene().getWindow();
		stage.close();
	}

	public void changeScene(ActionEvent event, String fxml) throws IOException {
		Parent dashboard = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxml)));
		Scene dashboardScene = new Scene(dashboard);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(dashboardScene);
		window.show();
	}

	@FXML private ImageView loginIcon;
	public void handleLoginButton(ActionEvent event) throws Exception {
		loginIcon.setVisible(true);

		String userName = this.userName.getText();
		String pass = this.pass.getText();

		String validation =  Account.validateLogin(userName,pass);
		switch (validation) {
			case "staff":{
				changeScene(event,"AdminDashboard.fxml");
				break;
			}
			case "customer": {
				changeScene(event,"CustomerDashboard.fxml");
				break;
			}
			default:
				invalidLabel.setVisible(true);
				Alert alert = new Alert(Alert.AlertType.ERROR, validation);
				alert.setHeaderText("Connection Failure");
				alert.showAndWait();
				break;
		}

	}


	@FXML
	public void handleRegisterButton(ActionEvent event) throws IOException {
		Parent register = FXMLLoader.load(getClass().getResource("Register.fxml"));
		Scene registerScene = new Scene(register);
		Stage window = new Stage();
		window.setScene(registerScene);
		window.setTitle("Regisztráció");
		//window.getIcons().add(new Image("pontus/Image/logo.jpg"));
		window.show();
	}

	@FXML
	public 	void onEnter(ActionEvent event) throws IOException {
		handleLoginButton(event);
	}

}
