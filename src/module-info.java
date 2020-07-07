module ERP {

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.sql;

    opens sample;
    opens sample.administrator;
    opens sample.faculty;
}