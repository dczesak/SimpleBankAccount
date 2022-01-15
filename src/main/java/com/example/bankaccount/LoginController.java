package com.example.bankaccount;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Label loginProblemLabel;

    @FXML
    private AnchorPane parent;

    @FXML
    private HBox top;

    @FXML
    private Pane content;

    @FXML
    private TextField loginTextField;

    @FXML
    private PasswordField passwordTextField;

    private double xOffSet = 0;
    private double yOffSet = 0;
    private Connection connection = DatabaseConnection.connectToDatabase();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        makeStageDraggable();

    }


    private void makeStageDraggable() {
        parent.setOnMousePressed((event) -> {
            xOffSet = event.getSceneX();
            yOffSet = event.getSceneY();
        });
        parent.setOnMouseDragged((event) -> {
            Main.stage.setX(event.getScreenX() - xOffSet);
            Main.stage.setY(event.getScreenY() - yOffSet);
            Main.stage.setOpacity(0.8f);
        });
        parent.setOnDragDone((event) -> {
            Main.stage.setOpacity(1.0f);
        });
        parent.setOnMouseReleased((event) -> {
            Main.stage.setOpacity(1.0f);
        });
    }

    @FXML
    private void minimize_stage(MouseEvent event) {
        Main.stage.setIconified(true);
    }

    @FXML
    private void close_app(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    private void handleLogin() throws IOException, SQLException {
        if (connection.isClosed()) {
            loginProblemLabel.setText("Error with database connection");
        } else {
            if (loginTextField.getText().equals("") || passwordTextField.getText().equals("")) {
                loginProblemLabel.setText("Enter login and password");
            } else {
                Parent menu = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main-window-view.fxml")));
                content.getChildren().removeAll();
                content.getChildren().setAll(menu);
            }
        }
    }

    @FXML
    private void handleLoginByKeyPressed(KeyEvent event) throws IOException, SQLException {
        if (event.getCode().equals(KeyCode.ENTER))
            handleLogin();
    }
}