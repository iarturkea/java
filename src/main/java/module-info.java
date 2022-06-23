module com.example.gbchat {
    requires javafx.controls;
    requires javafx.fxml;


    exports com.example.gbchat.client;
    opens com.example.gbchat.client to javafx.fxml;
}