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


        ////////////////  AdatBázis  Beolvasás   ////////////////////////
        try (CustomerDAO cDAO= new JpaCustomerDAO();){//customer beolvasás
            all_customers=cDAO.getCustomers();
        }
        try (ProductDAO pDAO= new JpaProductDAO();){//product beolvasás
            all_products=pDAO.getProducts();

        }
        //////////////////////////////////////////////////////////////////

        Product product =new Product();
        product.setName("Alma");
        all_products.add(product);

        ////////////////  AdatBázis  Mentés  //////////////////////
        try (CustomerDAO cDAO= new JpaCustomerDAO();){//customer mentés
            cDAO.saveCustomers(all_customers);
        }
        try (ProductDAO pDAO= new JpaProductDAO();){//product mentés
           pDAO.saveProducts(all_products);
        }
        //////////////////////////////////////////////////////////////////

        System.out.println("Open your browser and navigate to http://localhost:8082/");
        System.out.println("JDBC URL: jdbc:h2:file:./src\\main\\resources\\mydb");
        System.out.println("User Name: sa");
        System.out.println("Password: ");

    }
    private static void startDatabase() throws SQLException {
        new Server().runTool("-tcp", "-web", "-ifNotExists");
    }
}
