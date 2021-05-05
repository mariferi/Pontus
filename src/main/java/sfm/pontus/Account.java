package sfm.pontus;

abstract public class Account {
	protected Integer id;
	protected String userName;
	protected String password;

	public static final String VALID_PASSWORD_REGEX = "(?=^.{8,}$)(?=(.*[^A-Za-z]){2,})^.*";
	public static final String VALID_EMAIL_REGEX = "^(.+)@(.+)$";
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

	public static String validateLogin(String username, String password) throws Exception {
		return null;
	}
}
