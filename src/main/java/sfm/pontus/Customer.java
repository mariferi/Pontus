package sfm.pontus;

import javafx.beans.property.SimpleStringProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer extends Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;//name/passwd in Account
    private static final String VALID_PASSWORD_REGEX = "(?=^.{8,}$)(?=(.*[^A-Za-z]){2,})^.*";
    private static final String VALID_EMAIL_REGEX = "^(.+)@(.+)$";
    private String address;

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

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public Customer(String userName, String password, String address) {
        super(userName, password);
        this.address = address;
    }

    public static boolean validateEmail(String email) {
        return email.matches(VALID_EMAIL_REGEX);
    }
    public static boolean validatePassword(String password) {
        return password.matches(VALID_PASSWORD_REGEX);
    }


}
