module sfm.pontus {
    requires javafx.controls;
    requires javafx.fxml;

    opens sfm.pontus to javafx.fxml;
    exports sfm.pontus;
}
