package pontus;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class RegisterController {

	@FXML
	private TextField name;

	@FXML
	private TextField userName;

	@FXML
	private TextArea address;

	@FXML
	private PasswordField password;

	@FXML
	private PasswordField verifyPassword;

	@FXML
	private CheckBox policy;

	@FXML
	private CheckBox weeklyNews;

	@FXML
	private CheckBox yearlyNews;

	@FXML
	private Label invalidName;

	@FXML
	private Label invalidEmail;

	@FXML
	private Label invalidAddress;

	@FXML
	private Label invalidPassword;

	@FXML
	private Label invalidMatch;

	@FXML
	void handleBackButton(ActionEvent event) throws IOException {
            
	}

	public void handleAddButton() {
		invalidName.setVisible(false);
		invalidAddress.setVisible(false);
		invalidEmail.setVisible(false);
		invalidPassword.setVisible(false);
		invalidMatch.setVisible(false);

		if (name.getText().isEmpty()) {
			invalidName.setVisible(true);
		}
		if (address.getText().isEmpty()) {
			invalidAddress.setVisible(true);
		}

		if (userName.getText().isEmpty()) {
			invalidEmail.setVisible(true);

		}
		if (password.getText().isEmpty()) {
			invalidPassword.setVisible(true);
		} else if (!Customer.validateEmail(userName.getText())) {
			invalidEmail.setText("Invalid Email Address");
			invalidEmail.setVisible(true);

		} else if (!Customer.validatePassword(password.getText())) {
			invalidPassword.setText("Invalid Password");
			invalidPassword.setVisible(true);
			Alert alert = new Alert(Alert.AlertType.ERROR,
					" • Password must contain at least 2 non-alphabetic characters\n" +
							" • Password must be at least 8 characters long");
			alert.showAndWait();
		} else if (!password.getText().equals(verifyPassword.getText())) {
			invalidMatch.setVisible(true);
		} else {
			invalidName.setVisible(false);
			invalidAddress.setVisible(false);
			invalidEmail.setVisible(false);
			invalidPassword.setVisible(false);
			invalidMatch.setVisible(false);

			if (!policy.isSelected()) {
				Alert alert = new Alert(Alert.AlertType.WARNING, "Agree to our terms and conditions to continue");
				alert.showAndWait();
			} else {
				Customer.add(userName.getText(), verifyPassword.getText(), address.getText(), name.getText());
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setHeaderText("You have been succesfully registered to Pontus.\n" + "Thank you!");
				alert.showAndWait();

			}


		}
	}
}


