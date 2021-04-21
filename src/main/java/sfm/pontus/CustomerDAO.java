package sfm.pontus;

import javax.persistence.Id;
import java.util.List;

public interface CustomerDAO extends AutoCloseable{

    public void saveCustomer (Customer customer);
    public void deleteCustomer (Customer customer);
    public void updateCustomer (Customer customer);
    public List<Customer> getCustomersAll();
    public List<Customer> getCustomersbyName(String name);
    public Customer getCustomerbyID(int id);

}
