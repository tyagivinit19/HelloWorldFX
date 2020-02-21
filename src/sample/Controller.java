package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.fxml.FXMLLoader.load;

public class Controller {

    public AnchorPane mP;

    public void student(ActionEvent actionEvent) {

    }

    public void library(ActionEvent actionEvent) {
    }

    public void finance(ActionEvent actionEvent) {
    }

    public void admin(ActionEvent actionEvent) throws IOException, ClassNotFoundException {

        Parent newroot = FXMLLoader.load(getClass().getResource("logIn.fxml"));

        Stage stage = (Stage) mP.getScene().getWindow();
        stage.setScene(new Scene(newroot));
        stage.show();
    }
}
