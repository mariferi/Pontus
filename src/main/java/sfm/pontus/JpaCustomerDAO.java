package sfm.pontus;

import javax.persistence.*;
import java.util.List;

public class JpaCustomerDAO implements CustomerDAO{

    final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
    final EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public void saveCustomer(Customer customer) {
        entityManager.getTransaction().begin();
        entityManager.persist(customer);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteCustomer(Customer customer) {
        entityManager.getTransaction().begin();
        entityManager.remove(customer);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateCustomer(Customer customer) {
        saveCustomer(customer);
    }

    @Override
    public List<Customer> getCustomers() {
        TypedQuery<Customer> query=entityManager.createQuery("SELECT customer FROM Customer customer",Customer.class);
        List<Customer> customers =query.getResultList();
        return customers;
    }

    @Override
    public void saveCustomers(List<Customer> customers) {

        List<Customer> old_customers=getCustomers();
        for (Customer customer:old_customers){
            deleteCustomer(customer);//régi törlése
        }
        for (Customer customer:customers){
            saveCustomer(customer);//új mentése
        }
    }

    @Override
    public void close() throws Exception {
    entityManager.close();
    entityManagerFactory.close();
    }
}
