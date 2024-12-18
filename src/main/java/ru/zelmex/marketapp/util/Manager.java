package ru.zelmex.marketapp.util;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import ru.zelmex.marketapp.MarketApp;
import ru.zelmex.marketapp.model.User;

import java.io.IOException;
import java.util.Optional;

public class Manager {
    public static User currentUser = null;

    public static Stage startStage;
    public static Stage mainStage;
    public static Stage currentStage;

    public static boolean showExitWindow() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Закрыть приложение");
        alert.setHeaderText("Вы действительно хотите выйти?");
        Optional<ButtonType> result = alert.showAndWait();
        return result.get() == ButtonType.OK;
    }

    public static void showErrorMessageBox(String error) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка");
        alert.setHeaderText(error);
        alert.showAndWait();
    }


    public static void MessageBox(String title, String header, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static Optional<ButtonType> ShowConfirmWindow() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Удаление");
        alert.setHeaderText("Вы действительно хотите удалить запись?");
        alert.setContentText("Также будут удалены все зависимые записи");
        Optional<ButtonType> result = alert.showAndWait();
        return result;
    }

    public static void showStartStage(Stage stage, String fxmlFileName, String title) {
        try {
            stage.getIcons().add(new Image(MarketApp.class.getResourceAsStream("pen.png")));
            stage.setScene(createScene(fxmlFileName));
            stage.setTitle(title);
            stage.setResizable(false);
            stage.setOnCloseRequest(windowEvent -> {
                if (showExitWindow()) {
                    Platform.exit();
                }
                else {
                    windowEvent.consume();
                }
            });

            startStage = stage;
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static  Scene createScene(String fxmlFileName) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(MarketApp.class.getResource(fxmlFileName));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add("style.css");
        return scene;

    }

    public static void showMainStage(User person) {
        try {
            currentUser = person;
            mainStage = new Stage();
            mainStage.getIcons().add(new Image(MarketApp.class.getResourceAsStream("pen.png")));
            mainStage.setScene(createScene("main-view.fxml"));
            mainStage.setTitle("МАРКЕТ");
            mainStage.setMaximized(true);
            mainStage.setOnCloseRequest(windowEvent -> {
              startStage.show();
            });
            mainStage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }





}
