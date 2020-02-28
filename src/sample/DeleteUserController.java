package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.databaseClasses.FindPerson;

public class DeleteUserController {

    public ChoiceBox choiceBox;
    public TextField userName;
    public Label nameLabel;
    public Label msg;

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
        }

    }

    public void deletePerson(ActionEvent actionEvent) {
    }


}
