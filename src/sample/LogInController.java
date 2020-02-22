package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.databaseClasses.AdminLogIn;

public class LogInController {
    public TextField username;
    public TextField password;
    public Label msg;

    public void logIn(ActionEvent actionEvent) {

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
                msg.setText("Everything is all Right.");

                break;
            default:
                msg.setText("Something went Wrong.");


        }
    }
}
