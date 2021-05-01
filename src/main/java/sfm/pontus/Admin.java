package sfm.pontus;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin extends Account {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;//name/passwd in Account

	@Override
	public String toString() {
		return "Admin{" +
				"id=" + id +
				", userName='" + userName + '\'' +
				", password='" + password + '\'' +
				'}';
	}

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}


	public Admin(String userName, String password){
		super(userName, password);
	}

	@Override
	public static String getUser() {
		return "admin";
	}

	public static boolean validateEmail(String email) {
		return email.matches(VALID_EMAIL_REGEX);
	}
	public static boolean validatePassword(String password) {
		return password.matches(VALID_PASSWORD_REGEX);
	}

	public static String validateLogin(String username, String password) throws Exception {
		try (AdminDAO aDAO= new JpaAdminDAO()) {
			Admin Test = aDAO.getAdminbyName(username);

			if (username.isEmpty() || password.isEmpty()) {
				return "Enter username AND password";
			} else if (Test.getUserName().equals(username) && Test.getPassword().equals(password)) {
				return "Username AND Password OK";
			} else return "Wrong Username OR Password";
		}
	}

}
