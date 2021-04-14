package sfm.pontus;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

//Tibi importjai
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
//import java.sql.*;
/**
 * JavaFX App
 */
public class App extends Application {
/*
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch(args);
    }

*/    
    @Override
    public void start(Stage primaryStage) throws Exception {

        //loading the source from the login fxml file
        Parent root = FXMLLoader.load(getClass().getResource("FXMLs/Login.fxml"));
        primaryStage.setTitle("Pontus műszaki üzlet ");
        //Setting the stage style undecorated to use custom buttons
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root));
        primaryStage.getIcons().add(new Image("Store/Képek/bejelentkező.jpg"));
        primaryStage.setResizable(false);
        primaryStage.show();

    }


//
    /*
    private  static final String CONN = "jdbc:mysql://localhost/pontus";
      private static final String USERNAME="root";
      private static final String PASSWORD="";

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


    public static void App(String[] args){launch(args);}



    public static ResultSet executeQueryforRS(String statement){
        Connection connection;
        Statement st;
        ResultSet rs = null;
        try {
            connection = App.connectDB();
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
            connection = App.connectDB();
            st = connection.createStatement();
            st.executeUpdate(statement);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
*/
    
}