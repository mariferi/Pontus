<<<<<<< Updated upstream
module com.mycompany.mavenproject4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.mycompany.mavenproject4 to javafx.fxml;
    exports com.mycompany.mavenproject4;
    requires java.persistence;
=======
module sfm.pontus {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;
    requires javafx.base;
    requires javafx.graphics;
    requires javafx.media;
    requires javafx.web;
    requires javafx.swing;
    requires com.h2database;
    requires java.persistence;


    opens sfm.pontus to javafx.fxml, javafx.controls, javafx.graphics, javafx.base;
    exports sfm.pontus;
>>>>>>> Stashed changes
}