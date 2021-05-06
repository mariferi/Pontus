package pontus;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.h2.tools.Server;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("/fxml/Login.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) throws Exception {
        startDatabase();
        //launch(args);
       
        
        ////////////////  AdatBázis   ////////////////////////
        CustomerDAO cDAO= new JpaCustomerDAO();
        ProductDAO pDAO= new JpaProductDAO();
        AdminDAO aDAO=new JpaAdminDAO();
            //all_customers=cDAO.getCustomersAll();
            //all_products=pDAO.getProductsAll();
            //////////////////////////////////////////////////////////////////

        Customer Pista = new Customer("Pista", "alma", "Dabrecen");
        Admin Joska=new Admin("Jóska","körte");
        Product Alma=new Product("1221","Alma",new BigDecimal(50),"a");
        cDAO.saveCustomer(Pista);
        aDAO.saveAdmin(Joska);
        pDAO.saveProduct(Alma);

        
        //////////////////////////////////////////////////////////////////

        System.out.println("Open your browser and navigate to http://localhost:8082/");
        System.out.println("JDBC URL: jdbc:h2:file:./src\\main\\resources\\mydb");
        System.out.println("User Name: sa");
        System.out.println("Password: ");
        //stopDatabase();
    }

    private static Server s = new Server();
    
    private static void startDatabase() throws SQLException {
        s.runTool("-tcp", "-web", "-ifNotExists");
    }

    private static void stopDatabase()  {
        s.shutdown();
    }
    
}
