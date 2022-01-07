module com.example.bankaccount {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bankaccount to javafx.fxml;
    exports com.example.bankaccount;
}