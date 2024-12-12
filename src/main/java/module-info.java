module ru.zelmex.marketapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens ru.zelmex.marketapp to javafx.fxml;
    exports ru.zelmex.marketapp;
    exports ru.zelmex.marketapp.controller;
    opens ru.zelmex.marketapp.controller to javafx.fxml;
}