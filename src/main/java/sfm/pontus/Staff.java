package sfm.pontus;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;

public class Staff extends Account{
	@Override
	public void setId(Integer id) {
		this.id  = id;
	}
	public Integer getId() {
		return id;
	}

	public Staff(String userName, String password) {
		super(userName, password);
		this.userName = new String(userName);
		this.password = new String(password);
	}



	public static ObservableList<Cart> viewTransaction(String customerID) {
		return Purchase.getListFromDB(customerID);
	}
}
