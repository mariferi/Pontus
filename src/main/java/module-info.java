module hu.unideb.inf {

    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;
    requires javafx.base;
    requires javafx.graphics;
    requires com.h2database;
    requires java.persistence;


    opens hu.unideb.inf to javafx.fxml, javafx.controls, javafx.graphics, javafx.base;
    exports pontus;
}