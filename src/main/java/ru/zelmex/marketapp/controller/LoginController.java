package ru.zelmex.marketapp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ru.zelmex.marketapp.MarketApp;
import ru.zelmex.marketapp.model.User;
import ru.zelmex.marketapp.repository.UserDao;
import ru.zelmex.marketapp.util.Manager;
import static ru.zelmex.marketapp.util.Manager.screenSize;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static ru.zelmex.marketapp.util.Manager.ShowErrorMessageBox;

public class LoginController {
    UserDao userDao = new UserDao();
    @FXML
    private Button btnCancel;

    @FXML
    private Button btnOK;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField textFiedUsername;

    @FXML
    void btnCancelOnAction(ActionEvent event) {
        Manager.ShowPopup();
    }

    @FXML
    void btnOkOnAction(ActionEvent event) {

        List<User> users = userDao.findAll();
        Optional<User> person = users.stream().filter(user -> user.getUsername().equals(textFiedUsername.getText()) &&
                user.getPassword().equals(passwordField.getText())).findFirst();

        if (person.isEmpty())  {
            ShowErrorMessageBox("Не верный логин, пароль или текст капчи");
            return;
        }
            showMainWindow(person.get());
    }

    public void showMainWindow(User person) {
        Manager.currentUser = person;
        System.out.println(Manager.currentUser);
        Manager.mainStage.hide();
        Stage newWindow = new Stage();

        FXMLLoader fxmlLoader = new FXMLLoader(MarketApp.class.getResource("main-view.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), screenSize.getWidth(), screenSize.getHeight());
            scene.getStylesheets().add("style.css");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        newWindow.setTitle("МАРКЕТ");
        newWindow.setMaximized(true);
        newWindow.setScene(scene);
        newWindow.setOnCloseRequest(e -> {
            Manager.mainStage.show();
        });
        Manager.secondStage = newWindow;

        newWindow.show();
    }

}
