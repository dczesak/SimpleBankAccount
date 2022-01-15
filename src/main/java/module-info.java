module com.example.bankaccount {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.bankaccount to javafx.fxml;
    exports com.example.bankaccount;
}