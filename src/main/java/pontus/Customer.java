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
    private String userEmail;


	public static final String VALID_PASSWORD_REGEX = "(?=^.{8,}$)(?=(.*[^A-Za-z]){2,})^.*";
	public static final String VALID_EMAIL_REGEX = "^(.+)@(.+)$";


	public Customer() {

	}

	public Customer(String userName, String userEmail, String address, String password) {
		this.address = address;
		this.userName = userName;
		this.password = password;
		this.userEmail = userEmail;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Override
	public String toString() {
		return "Customer{" +
				"id=" + id +
				", address='" + address + '\'' +
				", userName='" + userName + '\'' +
				", password='" + password + '\'' +
				", userEmail='" + userEmail + '\'' +
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
	public static void register(String userName, String userEmail, String address, String password) throws Exception {
		Customer customer = new Customer(userName, userEmail, address, password);
		try (CustomerDAO cDAO= new JpaCustomerDAO();) {
			cDAO.saveCustomer(customer);
		}

		System.out.println("A regisztrált adatok:");
		System.out.println("Név: " + userName);
		System.out.println("Email: " + userEmail);
		System.out.println("Jelszó: " + password);
		System.out.println("Postázási cím: " + address);
	}
	//**************************************************************************************************


}
