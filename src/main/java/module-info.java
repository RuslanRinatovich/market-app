module ru.zelmex.marketapp {
    requires javafx.controls;
    requires java.naming;
    requires java.desktop;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires org.hibernate.validator;
    requires org.postgresql.jdbc;
    opens ru.zelmex.marketapp.model to org.hibernate.orm.core, javafx.base;

    opens ru.zelmex.marketapp to javafx.fxml;
    exports ru.zelmex.marketapp;
    exports ru.zelmex.marketapp.controller;
    opens ru.zelmex.marketapp.controller to javafx.fxml;
}