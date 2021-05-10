package pontus;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public Integer id;
	public String userName;
	public String password;
	public static final String VALID_PASSWORD_REGEX = "(?=^.{8,}$)(?=(.*[^A-Za-z]){2,})^.*";
	public static final String VALID_EMAIL_REGEX = "^(.+)@(.+)$";

	public Admin(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
        
	public Admin() {
	}

	public Admin retAdmin() {
		return this;
	}

	@Override
	public String toString() {
		return "Admin{" +
				"id=" + id +
				", userName='" + userName + '\'' +
				", password='" + password + '\'' +
				'}';
	}

	public void setId(Integer id){
		this.id=id;
	}
	public Integer getId() {
		return this.id;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName=userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password=password;
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
