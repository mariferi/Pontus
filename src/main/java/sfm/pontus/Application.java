package sfm.pontus;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.h2.tools.Server;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Application extends javafx.application.Application{

    public static void main(String[] args) throws Exception {
        startDatabase();
        ////////////////  AdatBázis   ////////////////////////
        try (CustomerDAO cDAO= new JpaCustomerDAO();
             ProductDAO pDAO= new JpaProductDAO();
             AdminDAO aDAO=new JpaAdminDAO();){
            //all_customers=cDAO.getCustomersAll();
            //all_products=pDAO.getProductsAll();
        //////////////////////////////////////////////////////////////////

            Customer Pista = new Customer("Pista", "alma", "Dabrecen");
            Admin Joska=new Admin("Jóska","körte");
            Product Alma=new Product("1221","Alma",new BigDecimal(50),"a");

        }
        //////////////////////////////////////////////////////////////////

        System.out.println("Open your browser and navigate to http://localhost:8082/");
        System.out.println("JDBC URL: jdbc:h2:file:./src\\main\\resources\\mydb");
        System.out.println("User Name: sa");
        System.out.println("Password: ");

    }

    private static Scene scene;

    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("Login"));
        stage.setTitle("Pontus műszaki üzlet ");
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    private static void startDatabase() throws SQLException {
        new Server().runTool("-tcp", "-web", "-ifNotExists");
    }
}
