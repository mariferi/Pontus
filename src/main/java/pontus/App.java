package pontus;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.sql.SQLException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
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
        
        /////////////   AdatBázis Info ////////////////////////////////////////

        System.out.println("Open your browser and navigate to http://localhost:8082/");
        System.out.println("JDBC URL: jdbc:h2:file:./src\\main\\resources\\mydb");
        System.out.println("User Name: sa");
        System.out.println("Password: ");
        ////////////////  JAVAFX    ///////////////////////////////////////
        launch(args);
        stopDatabase();
    }

    private static Server s = new Server();
    
    private static void startDatabase() throws SQLException {
        s.runTool("-tcp", "-web", "-ifNotExists");
    }

    public static void stopDatabase()  {
        s.shutdown();
    }
    
}
