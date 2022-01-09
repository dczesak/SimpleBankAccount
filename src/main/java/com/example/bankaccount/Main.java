package com.example.bankaccount;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {

    public static Stage stage = null;

    @Override
    public void start(Stage stage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("login-view.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);

        stage.show();


//        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 1024, 580);
//        stage.setScene(scene);
//        stage.initStyle(StageStyle.UNDECORATED);
//        this.stage = stage;
//        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}