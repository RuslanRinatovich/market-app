package ru.zelmex.marketapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

import static ru.zelmex.marketapp.util.Manager.showStartStage;

public class MarketApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        showStartStage(stage, "login-view.fxml", "Авторизация");
    }

    public static void main(String[] args) {
        launch();
    }
}