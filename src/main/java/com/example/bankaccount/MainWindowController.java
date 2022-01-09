package com.example.bankaccount;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {

    @FXML
    private AnchorPane content;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void handle_logout(ActionEvent event) throws IOException {
        Parent menu = FXMLLoader.load(getClass().getResource("login-view.fxml"));
        content.getChildren().removeAll();
        content.getChildren().setAll(menu);
    }
}
