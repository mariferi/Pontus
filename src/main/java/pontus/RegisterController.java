package sfm.pontus;

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
		Application.setRoot("Login");
	}

	public void handleAddButton() {

		if (name.getText().isEmpty()) {
			invalidName.setVisible(true);
		} else invalidName.setVisible(false);
		if (address.getText().isEmpty()) {
			invalidAddress.setVisible(true);
		} else invalidAddress.setVisible(false);

		if (userName.getText().isEmpty()) {
			invalidEmail.setVisible(true);

		} else {
			if (!Customer.validateEmail(userName.getText())) {
				invalidEmail.setText("Invalid Email Address");
				invalidEmail.setVisible(true);
			} else {
				invalidEmail.setVisible(false);
			}
		}
		if (password.getText().isEmpty()) {
			invalidPassword.setVisible(true);
		} else {
			if (!Customer.validatePassword(password.getText())) {
				invalidPassword.setText("Invalid Password");
				invalidPassword.setVisible(true);
				Alert alert = new Alert(Alert.AlertType.ERROR,
						" • Password must contain at least 2 non-alphabetic characters\n" +
								" • Password must be at least 8 characters long");
				alert.showAndWait();
			} else invalidPassword.setVisible(false);
			if (!password.getText().equals(verifyPassword.getText())) {
				invalidMatch.setVisible(true);
			} else {
				invalidMatch.setVisible(false);
				if (!policy.isSelected()) {
					Alert alert = new Alert(Alert.AlertType.WARNING, "Agree to our terms and conditions to continue");
					alert.showAndWait();
				} else {
					Customer.add(userName.getText(), verifyPassword.getText(), address.getText(), name.getText());
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setHeaderText("Thank you");

				}

			}

		}
	}

}
