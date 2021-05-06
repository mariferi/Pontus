<<<<<<< HEAD
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
>>>>>>> 2993958a8ffa868c11633a799c8caff2f87071e8
}