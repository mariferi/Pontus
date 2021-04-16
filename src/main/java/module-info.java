module sfm.pontus {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;
    requires javafx.base;
    requires javafx.graphics;




    opens sfm.pontus to javafx.fxml;
    exports sfm.pontus;
}
