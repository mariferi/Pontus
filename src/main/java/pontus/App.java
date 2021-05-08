package pontus;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.sql.SQLException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.h2.tools.Server;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("/fxml/Login.fxml"));
        Scene scene = new Scene(loader.load());
        stage.getIcons().add(new Image(new FileInputStream("src\\main\\resources\\Képek\\bejelentkező.jpg")));
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) throws Exception {
        ////////////////  AdatBázis   ////////////////////////
        startDatabase();
        try (CustomerDAO cDAO= new JpaCustomerDAO();
             ProductDAO pDAO= new JpaProductDAO();
             AdminDAO aDAO = new JpaAdminDAO();){
            //all_customers=cDAO.getCustomersAll();
            //all_products=pDAO.getProductsAll();
        //////////////////////////////////////////////////////////////////
        /*Customer Pista = new Customer("Teszt Pista", "pistikerulez", "Nagyfalva");
        Admin Joska=new Admin("Jóska_baba83","körte234");
        Product Alma=new Product("12212","Zöld Alma",new BigDecimal(49.9),"kicsi");
        cDAO.saveCustomer(Pista);
        aDAO.saveAdmin(Joska);
        pDAO.saveProduct(Alma);
         */
        }

        
        //////////////////////////////////////////////////////////////////

        System.out.println("Open your browser and navigate to http://localhost:8082/");
        System.out.println("JDBC URL: jdbc:h2:file:./src\\main\\resources\\mydb");
        System.out.println("User Name: sa");
        System.out.println("Password: ");
        ////////////////////////////////////////////////////////////////////
        launch(args);
    }

    private static Server s = new Server();
    
    private static void startDatabase() throws SQLException {
        s.runTool("-tcp", "-web", "-ifNotExists");
    }

    private static void stopDatabase()  {
        s.shutdown();
    }
    
}
