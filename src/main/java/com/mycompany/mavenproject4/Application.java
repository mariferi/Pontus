package com.mycompany.mavenproject4;

import java.io.IOException;
import java.sql.SQLException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.h2.tools.Server;

public class Application {
    
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

    public static void main(String[] args) throws SQLException {
        startDatabase();
        ////////////////  AdatBázis   ////////////////////////
        try (CustomerDAO cDAO = new JpaCustomerDAO();
             ProductDAO pDAO = new JpaProductDAO();){
            //all_customers=cDAO.getCustomersAll();
            //all_products=pDAO.getProductsAll();
        //////////////////////////////////////////////////////////////////


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
