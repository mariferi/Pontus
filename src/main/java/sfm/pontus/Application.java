package sfm.pontus;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.h2.tools.Server;

public class Application {

    public static void main(String[] args) throws Exception {
        startDatabase();
        List<Product> all_products;
        List<Customer> all_customers;

        Customer customer2 = new Customer();
        customer2.setFirstName("Kiss");
        customer2.setLastName("Pista");

        try (CustomerDAO cDAO= new JpaCustomerDAO();){//customer db
            all_customers=cDAO.getCustomers();
            cDAO.saveCustomer(customer2);
        }


        Product product1 =new Product();
        product1.setName("Samsung Galaxy S8");

        try (ProductDAO pDAO= new JpaProductDAO();){//product db
            pDAO.saveProduct(product1);
           all_products=pDAO.getProducts();
           //Stock Raktar=new Stock("Fő Raktár");//csak egyszer fut le aztán error mert már  létezik eza raktár
           //Raktar.getProducts().addAll(all_products);
           //pDAO.saveStock(Raktar);
        }



        for (Customer cust : all_customers){
            System.out.println(cust);
        }

        for (Product prod : all_products){
            System.out.println(prod);
        }


        System.out.println("Open your browser and navigate to http://localhost:8082/");
        System.out.println("JDBC URL: jdbc:h2:file:./src\\main\\resources\\mydb");
        System.out.println("User Name: sa");
        System.out.println("Password: ");

    }
    private static void startDatabase() throws SQLException {
        new Server().runTool("-tcp", "-web", "-ifNotExists");
    }
}
