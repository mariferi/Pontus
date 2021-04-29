package sfm.pontus;

import javafx.beans.property.SimpleStringProperty;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

abstract public class Account {
	protected Integer id;
	protected String userName;
	protected String password;

	abstract public void setId(Integer id);
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



	public Account(String userName, String password) {

		this.userName = new String(userName);
		this.password = new String(password);

	}


	public static String validateLogin(String username, String password) {
		Account Test= getAccbyname(username);
		if (username.isEmpty() || password.isEmpty()) {
			return "Enter username AND password";
		} else if (Test.getUserName().equals(username) && Test.getPassword().equals(password)) {
			return "Username and Password OK";
		}
		else return "Wrong Username or Password";
	}
}