module com.example.wodhub {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.wodhub to javafx.fxml;
    exports com.example.wodhub;
}