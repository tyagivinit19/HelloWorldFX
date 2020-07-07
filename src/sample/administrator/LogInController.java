package sample.administrator;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.administrator.databaseClasses.AdminLogIn;

import java.io.IOException;

public class LogInController {
    public TextField username;
    public TextField password;
    public Label msg;
    public AnchorPane l;

    public void logIn(ActionEvent actionEvent) throws IOException {

        String user = username.getText();
        String pass = password.getText();

        AdminLogIn al = new AdminLogIn();
        int status = al.searchAdmin(user, pass);

        switch(status)
        {
            case 0:
                msg.setText("Something went Wrong.");
                break;
            case 1:
                msg.setText("Wrong Username.");
                break;
            case 2:
                msg.setText("Wrong Password.");
                break;
            case 3:
//                msg.setText("Everything is all Right.");
                Parent newroot = FXMLLoader.load(getClass().getResource("adminMainPage.fxml"));

                Stage stage = (Stage) l.getScene().getWindow();
                stage.setScene(new Scene(newroot));
                stage.show();
                break;
            default:
                msg.setText("Something went Wrong.");


        }
    }
}
