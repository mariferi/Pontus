module pontus {

    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;
    requires javafx.base;
    requires javafx.graphics;
    requires com.h2database;
    requires java.persistence;
   

    opens pontus to javafx.fxml, javafx.controls, javafx.graphics, javafx.base;
    exports pontus;
    
    requires junit;
    
}