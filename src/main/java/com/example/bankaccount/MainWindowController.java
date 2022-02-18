package com.example.bankaccount;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {

    @FXML
    private AnchorPane content;

    @FXML
    private Label helloLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        helloLabel.setText("Welcome " + LoginSession.firstName + " " + LoginSession.lastName);
    }

    @FXML
    private void handle_logout(ActionEvent event) throws IOException, SQLException {
        Parent menu = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login-view.fxml")));
        content.getChildren().removeAll();
        content.getChildren().setAll(menu);
        DatabaseConnection.connectToDatabase().close();
        LoginSession.firstName = "";
        LoginSession.lastName = "";
    }
}
