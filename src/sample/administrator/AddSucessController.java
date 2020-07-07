package sample.administrator;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AddSucessController {
    public AnchorPane aS;

    public void mainMenu(ActionEvent actionEvent) throws IOException {

        Parent newroot = FXMLLoader.load(getClass().getResource("adminMainPage.fxml"));

        Stage stage = (Stage) aS.getScene().getWindow();
        stage.setScene(new Scene(newroot));
        stage.show();
    }
}
