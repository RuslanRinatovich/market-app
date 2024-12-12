package ru.zelmex.marketapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import ru.zelmex.marketapp.util.Manager;

import java.io.IOException;

public class MarketApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.getIcons().add(new Image(MarketApp.class.getResourceAsStream("pen.png")));
        stage.setScene(getNewScene());
        stage.setTitle("Авторизация!");
        stage.setResizable(false);
        stage.setOnCloseRequest(event -> {
            Manager.ShowPopup();
        });
        stage.setOnShown(windowEvent -> {
            try {
                stage.setScene(getNewScene());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        Manager.mainStage = stage;
        stage.show();
    }

    Scene getNewScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MarketApp.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add("style.css");
        return scene;
    }

    public static void main(String[] args) {
        launch();
    }
}