module sfm.pontus {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
	requires java.desktop;

	opens sfm.pontus to javafx.fxml;
    exports sfm.pontus;
}