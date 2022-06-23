module com.example.ics372v2_project {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires json.simple;

    opens com.example.ics372v2_project to javafx.fxml;
    exports com.example.ics372v2_project;
    exports animal_shelter_GUI;
    opens animal_shelter_GUI to javafx.fxml;
}