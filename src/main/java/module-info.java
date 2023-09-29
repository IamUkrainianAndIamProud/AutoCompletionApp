module com.example.autocompletionapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.autocompletionapp to javafx.fxml;
    exports com.example.autocompletionapp;
}