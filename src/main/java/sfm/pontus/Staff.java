package sfm.pontus;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;

/**
 *
 * @author Tibi
 */

public class Staff extends Account  {

    @Override
    public void setId(Integer id) {
        this.id  = id;
    }

    public Staff(String userName, String password) {
        super(userName, password);
        this.userName = new SimpleStringProperty(userName);
        this.password = new SimpleStringProperty(password);
    }


    public Integer getId() {
        return id;
    }




    public static ObservableList<Cart> viewTransaction(String customerID) {
        ObservableList ob = Purchase.getListFromDB(customerID);
        return ob;
    }


}