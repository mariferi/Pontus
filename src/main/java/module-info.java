module com.mycompany.mavenproject4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.mycompany.mavenproject4 to javafx.fxml;
    exports com.mycompany.mavenproject4;
    requires java.persistence;
}