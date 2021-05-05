/*
package sfm.pontus;

import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.h2.tools.Server;

public class Application {

    public static void main(String[] args) throws SQLException {
        startDatabase();

        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
        final EntityManager entityManager = entityManagerFactory.createEntityManager();

        Customer customer = new Customer();
        customer.setFirstName("Dennys");
        customer.setLastName("Fredericci");

        entityManager.getTransaction().begin();
        entityManager.persist(customer);
        entityManager.getTransaction().commit();

        System.out.println("Open your browser and navigate to http://localhost:8082/");
        System.out.println("JDBC URL: jdbc:h2:mem:my_database");
        System.out.println("User Name: sa");
        System.out.println("Password: ");

    }

    private static void startDatabase() throws SQLException {
        new Server().runTool("-tcp", "-web", "-ifNotExists");
    }
}

*/
package sfm.pontus;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;


//Tibi importjai
import javafx.scene.image.Image;
import javafx.stage.StageStyle;
import org.h2.tools.Server;

import java.math.BigDecimal;
import java.sql.*;


public class Application extends javafx.application.Application {

	private static Scene scene;
	private Stage primaryLogin;


    @Override
    public void start(Stage Login) throws IOException {
        scene = new Scene(loadFXML("Login"));
        //Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));

        Login.initStyle(StageStyle.UNDECORATED);		//saját stilusu bezáró X gomb
		Login.getIcons().add(new Image(new FileInputStream("C:\\Users\\gyurc\\IdeaProjects\\Pontus\\src\\main\\resources\\Képek\\bejelentkező.jpg")));

		Login.setTitle("Pontus műszaki üzlet");
		Login.setScene(scene);
		Login.setResizable(true);
		Login.show();

    }
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));

    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }



	public static void main(String[] args) throws Exception {
        startDatabase();
        launch(args);
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
    private static void startDatabase() throws SQLException {
        new Server().runTool("-tcp", "-web", "-ifNotExists");
    }



}