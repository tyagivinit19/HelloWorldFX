package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import sample.databaseClasses.FindPerson;

import java.sql.SQLException;

public class ShowDetailsController {
    public Label userName;
    public Label name;
    public Label address;
    public Label phone;
    public Label branch;


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


    public void mainMenu(ActionEvent actionEvent) {
    }
}