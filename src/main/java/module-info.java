module ru.zelmex.marketapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.naming;
    requires java.desktop;
    requires org.postgresql.jdbc;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    opens ru.zelmex.marketapp.model to org.hibernate.orm.core, javafx.base;
    opens ru.zelmex.marketapp to javafx.fxml;
    exports ru.zelmex.marketapp;
    exports ru.zelmex.marketapp.controller;
    opens ru.zelmex.marketapp.controller to javafx.fxml;
}