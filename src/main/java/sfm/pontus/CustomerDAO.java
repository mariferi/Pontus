package sfm.pontus;

import java.util.List;

public interface CustomerDAO extends AutoCloseable{

    public void saveCustomer (Customer customer);
    public void deleteCustomer (Customer customer);
    public void updateCustomer (Customer customer);
    public List<Customer> getCustomers();
}
