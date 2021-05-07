package pontus;

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
    public List<Customer> getCustomersAll() {
        String sqlstr="SELECT customer FROM Customer customer";
        TypedQuery<Customer> query=entityManager.createQuery(sqlstr,Customer.class);
        return query.getResultList();
    }

    @Override
    public List<Customer> getCustomersbyName(String name) {
        String sqlstr="SELECT customer FROM Customer customer WHERE NAME="+"'"+name+"'";
        TypedQuery<Customer> query=entityManager.createQuery(sqlstr,Customer.class);
        return query.getResultList();
    }
    @Override
    public Customer getCustomerbyName(String name) {//Veszélyes
        String sqlstr="SELECT customer FROM Customer customer WHERE NAME="+"'"+name+"'";
        TypedQuery<Customer> query=entityManager.createQuery(sqlstr,Customer.class);
        return query.getSingleResult();
    }

    @Override
    public Customer getCustomerbyID(int id) {
        String sqlstr="SELECT customer FROM Customer customer WHERE ID="+id;
        TypedQuery<Customer> query=entityManager.createQuery(sqlstr,Customer.class);
        return query.getSingleResult();
    }


    @Override
    public void close() throws Exception {
    entityManager.close();
    entityManagerFactory.close();
    }
}
