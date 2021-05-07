package pontus;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String address;
	private String userName;
    private String password;
    private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static final String VALID_PASSWORD_REGEX = "(?=^.{8,}$)(?=(.*[^A-Za-z]){2,})^.*";
	public static final String VALID_EMAIL_REGEX = "^(.+)@(.+)$";

	public Customer(String userName, String password, String address) {
		this.userName=userName;
		this.password=password;
		this.address = address;
	}

	public Customer() {

	}

	@Override
	public String toString() {
		return "Customer{" +
				"id=" + id +
				", address='" + address + '\'' +
				", userName='" + userName + '\'' +
				'}';
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
        public String userName() {
		return userName;
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
		try (CustomerDAO cDAO= new JpaCustomerDAO()) {
			Customer Test = cDAO.getCustomerbyName(username);

			if (username.isEmpty() || password.isEmpty()) {
				return "Enter username AND password";
			} else if (Test.getUserName().equals(username) && Test.getPassword().equals(password)) {
				return "Username AND Password OK";
			} else return "Wrong Username OR Password";
		}
	}
	//*******************MÓDÓSÍTANI KELL HOGY MEGHÍVJA A SAJÁT ADATBÁZIS METÓDUST***************************
	public static void add(String username, String password, String address, String name) {
		/*
		Application.executeQueryforUpdate("INSERT INTO customer (userName, password,address,name) VALUES ('"
				+ username + "', '" + password + "','" + address + "','" + name + "')");
		*/
		System.out.println("A regisztrált adatok:");
		System.out.println("Név: " + name);
		System.out.println("Felhasználónév: " + username);
		System.out.println("Jelszó: " + password);
		System.out.println("Postázási cím: " + address);
	}
	//**************************************************************************************************


}
