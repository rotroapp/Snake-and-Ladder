module com.example.smake {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.smake to javafx.fxml;
    exports com.example.smake;
}