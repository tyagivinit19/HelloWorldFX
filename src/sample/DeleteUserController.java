package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.databaseClasses.DeletePerson;
import sample.databaseClasses.FindPerson;

import java.io.IOException;
import java.sql.SQLException;

public class DeleteUserController {

    public ChoiceBox choiceBox;
    public TextField userName;
    public Label nameLabel;
    public Label msg;
    public Button deletePerson;
    public AnchorPane dU;

    public void findPerson(ActionEvent actionEvent) {

        String userName = this.userName.getText();
        String branch = (String) choiceBox.getValue();

        FindPerson ob = new FindPerson();
        String  status = ob.find(userName, branch);

        switch (status)
        {
            case "u":
                msg.setText("Enter UserName.");
                nameLabel.setText("");
                break;
            case "b":
                msg.setText("Select the Branch.");
                nameLabel.setText("");
                break;
            case "nF":
                msg.setText("UserName is not Found.");
                nameLabel.setText("");
                break;
            default:
                nameLabel.setText(status);
                deletePerson.setDisable(false);
        }

    }

    public void deletePerson(ActionEvent actionEvent) throws SQLException, IOException {

        String userName = this.userName.getText();
        String branch = (String) choiceBox.getValue();

        DeletePerson deletePerson = new DeletePerson();
        deletePerson.delete(userName, branch);

        this.deletePerson.setDisable(true);

        Parent newroot = FXMLLoader.load(getClass().getResource("adminMainPage.fxml"));

        Stage stage = (Stage) dU.getScene().getWindow();
        stage.setScene(new Scene(newroot));
        stage.show();
        

    }


}
