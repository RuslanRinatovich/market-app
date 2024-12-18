package ru.zelmex.marketapp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import ru.zelmex.marketapp.model.User;
import ru.zelmex.marketapp.repository.UserDao;

import java.util.List;
import java.util.Optional;

import static ru.zelmex.marketapp.util.Manager.showErrorMessageBox;
import static ru.zelmex.marketapp.util.Manager.showMainStage;

public class LoginController {

    UserDao userDao = new UserDao();

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnOK;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField textFieldUsername;

    @FXML
    void btnCancelOnAction(ActionEvent event) {

    }

    @FXML
    void btnOkOnAction(ActionEvent event) {
        List<User> users = userDao.findAll();
        Optional<User> user = users.stream().filter(user1 -> user1.getUsername().equals(textFieldUsername.getText()) &&
                user1.getPassword().equals(passwordField.getText())).findFirst();

        if (user.isEmpty())
        {
            showErrorMessageBox("Не верный логин или пароль");
            return;
        }
        showMainStage(user.get());
    }

}
