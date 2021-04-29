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
package controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;


//Tibi importjai
import javafx.scene.image.Image;
import javafx.stage.StageStyle;
import java.sql.*;


public class Application extends javafx.application.Application {

	private static Scene scene;
	private Stage primaryLogin;


    @Override
    public void start(Stage Login) throws IOException {
        scene = new Scene(loadFXML("Login"), 720, 480);
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



	public static void main(String[] args) {
		launch(args);
	}

	//

    private  static final String CONN = "jdbc:h2:mem:my_database";
    private static final String USERNAME="sa";
    private static final String PASSWORD="sa";

    //

    public static Connection connectDB() {
        try {
            Connection con = DriverManager.getConnection(CONN, USERNAME, PASSWORD);
            return con;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static ResultSet executeQueryforRS(String statement){
        Connection connection;
        Statement st;
        ResultSet rs = null;
        try {
            connection = Application.connectDB();
            st = connection.createStatement();
            rs = st.executeQuery(statement);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;

    }

    public static void executeQueryforUpdate(String statement){
        Connection connection;
        Statement st;
        try {
            connection = Application.connectDB();
            st = connection.createStatement();
            st.executeUpdate(statement);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


}