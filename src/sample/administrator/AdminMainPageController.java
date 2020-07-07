package sample.administrator;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminMainPageController {


    public AnchorPane aMP;

    public void addUser(ActionEvent actionEvent) throws IOException {
        System.out.println("addUser");

        Parent newroot = FXMLLoader.load(getClass().getResource("addUser.fxml"));

        Stage stage = (Stage) aMP.getScene().getWindow();
        stage.setScene(new Scene(newroot));
        stage.show();

    }

    public void deleteUser(ActionEvent actionEvent) throws IOException {

        System.out.println("deleteUser");

        Parent newroot = FXMLLoader.load(getClass().getResource("deleteUser.fxml"));

        Stage stage = (Stage) aMP.getScene().getWindow();
        stage.setScene(new Scene(newroot));
        stage.show();


    }

    public void details(ActionEvent actionEvent) throws IOException {

        System.out.println("details of user");
        Parent newroot = FXMLLoader.load(getClass().getResource("detailUser.fxml"));

        Stage stage = (Stage) aMP.getScene().getWindow();
        stage.setScene(new Scene(newroot));
        stage.show();

    }


}
