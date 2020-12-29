package sample.administrator;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.administrator.databaseClasses.FindPerson;

import java.io.IOException;
import java.sql.SQLException;

public class DetailUserController {

    public TextField userName;
    public ChoiceBox choiceBox;
    public Label msg;
    public AnchorPane dU;

    public void details(ActionEvent actionEvent) throws IOException, SQLException {

        String userName = this.userName.getText();
        String branch = (String) this.choiceBox.getValue();

        FindPerson ob = new FindPerson();
        String status = ob.find(userName, branch);

        switch (status) {
            case "u":
                this.msg.setText("Enter UserName.");
                break;

            case "b":
                this.msg.setText("Select the Branch.");
                break;

            case "nF":
                this.msg.setText("UserName is not Found.");
                break;

            default:

                FXMLLoader loader = new FXMLLoader(getClass().getResource("showDetails.fxml"));
                Parent newroot = loader.load();

                Stage stage = (Stage) dU.getScene().getWindow();

                ShowDetailsController showDetailsController = loader.getController();
                showDetailsController.setUserName(userName);
                showDetailsController.setBranch(branch);
                showDetailsController.setDetails();
                System.out.println(branch);

                stage.setScene(new Scene(newroot));
                stage.show();




        }


    }

    public void back(ActionEvent actionEvent) throws IOException {

        Parent newroot = FXMLLoader.load(getClass().getResource("adminMainPage.fxml"));

        Stage stage = (Stage) dU.getScene().getWindow();
        stage.setScene(new Scene(newroot));
        stage.show();
    }
}