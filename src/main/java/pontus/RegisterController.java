package pontus;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterController {

	@FXML	private TextField userName;
	@FXML	private TextField userEmail;
	@FXML	private TextArea address;
	@FXML	private PasswordField password;
	@FXML	private PasswordField verifyPassword;
	@FXML	private CheckBox policy;
	@FXML	private Label invalidName;
	@FXML	private Label invalidEmail;
	@FXML	private Label invalidAddress;
	@FXML	private Label invalidPassword;
	@FXML	private Label invalidMatch;


	public void handleAddButton(ActionEvent event) throws Exception {
		invalidName.setVisible(false);
		invalidAddress.setVisible(false);
		invalidEmail.setVisible(false);
		invalidPassword.setVisible(false);
		invalidMatch.setVisible(false);

		if (userName.getText().isEmpty()) {
			invalidName.setVisible(true);
		}
		if (address.getText().isEmpty()) {
			invalidAddress.setVisible(true);
		}

		if (userEmail.getText().isEmpty()) {
			invalidEmail.setVisible(true);

		}
		if (password.getText().isEmpty()) {
			invalidPassword.setVisible(true);
		} else if (!Customer.validateEmail(userEmail.getText())) {
			invalidEmail.setText("Érvénytelen E-mail cím!");
			invalidEmail.setVisible(true);

		} else if (!Customer.validatePassword(password.getText())) {
			invalidPassword.setText("Érvénytelen Jelszó!");
			invalidPassword.setVisible(true);
			Alert alert = new Alert(Alert.AlertType.ERROR,
					" • A Jelszóban legalább 2db szám vagy bármilyen nem betű karakternek is lennie kell!\n" +
							" • A Jelszónak minimum 8 karakternek kell lennie!");
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
				Alert alert = new Alert(Alert.AlertType.WARNING, "Fogadja el Felhasználási feltételeinket");
				alert.showAndWait();
			} else {
				Customer.register(userName.getText(),userEmail.getText(), address.getText(), verifyPassword.getText());
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setHeaderText("Sikeresen regisztrált a Pontus shop-ba.\n" + "Üdvözöljük!");
				alert.showAndWait();
				Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				stage.close();
			}


		}
	}
}


