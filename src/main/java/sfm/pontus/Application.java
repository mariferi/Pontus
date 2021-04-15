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

        Customer customer2 = new Customer();
        customer2.setFirstName("Kiss");
        customer2.setLastName("Pista");

        try (CustomerDAO cDAO= new JpaCustomerDAO();){
            cDAO.saveCustomer(customer2);
        }


        Product prod =new Product();
        prod.setName("Samsung Galaxy S8");

        try (ProductDAO pDAO= new JpaProductDAO();){
            pDAO.saveProduct(prod);
            List<Product> all_products=pDAO.getProducts();
            Stock Raktar=new Stock("Fő Raktár");//csak egyszer fut le aztán error mert már  létezik
            Raktar.getProducts().addAll(all_products);
            pDAO.saveStock(Raktar);
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
