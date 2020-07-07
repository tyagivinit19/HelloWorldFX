package sample.administrator;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.administrator.databaseClasses.FindPerson;

import java.io.IOException;
import java.sql.SQLException;

public class ShowDetailsController {
    public Label userName;
    public Label name;
    public Label address;
    public Label phone;
    public Label branch;
    public AnchorPane sD;


    public void setUserName(String userName) {
        this.userName.setText(userName);
    }

    public void setBranch(String branch) {
        this.branch.setText(branch);
        System.out.println("B" + branch);
    }

//    public ShowDetailsController() {
//        System.out.println("Called");
////        System.out.println(this.userName.getText()+"last");
//    }

    public void setDetails() throws SQLException {
//        System.out.println(this.userName.getText()+"last");

        FindPerson findPerson = new FindPerson();
        findPerson.personDetails(this);


    }

    public void showDetails(String name, String address, String phone)
    {
        this.name.setText(name);
        this.address.setText(address);
        this.phone.setText(phone);
    }


    public void mainMenu(ActionEvent actionEvent) throws IOException {

        Parent newroot = FXMLLoader.load(getClass().getResource("adminMainPage.fxml"));

        Stage stage = (Stage) sD.getScene().getWindow();
        stage.setScene(new Scene(newroot));
        stage.show();
    }
}