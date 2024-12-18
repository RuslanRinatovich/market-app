package ru.zelmex.marketapp.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

import static ru.zelmex.marketapp.util.Manager.currentUser;

public class MainController implements Initializable {

    @FXML
    private Label labelUser;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        labelUser.setText(currentUser.getFirstName());
    }
}
