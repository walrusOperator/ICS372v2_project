module com.example.ics372v2_project {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.ics372v2_project to javafx.fxml;
    exports com.example.ics372v2_project;
}