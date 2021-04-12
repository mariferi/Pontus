module sfm.pontus {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.sql;

	opens sfm.pontus to javafx.fxml;
    exports sfm.pontus;
}
