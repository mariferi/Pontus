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
        ////////////////  AdatBázis   ////////////////////////
        try (//CustomerDAO cDAO= new JpaCustomerDAO();
             ProductDAO pDAO= new JpaProductDAO();){
            //all_customers=cDAO.getCustomers();
            //all_products=pDAO.getAllProducts();
        //////////////////////////////////////////////////////////////////

            //Customer jön
        Product product =new Product();
        product.setName("Füge");
        pDAO.saveProduct(product);

        System.out.println(pDAO.getproductbyID(product.getId()).toString());

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
