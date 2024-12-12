package ru.zelmex.marketapp.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import ru.zelmex.marketapp.util.Manager;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private Label labelUser;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        labelUser.setText(Manager.currentUser.getFirstName());
    }
}
