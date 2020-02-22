package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class LogInController {
    public TextField username;
    public TextField password;

    public void logIn(ActionEvent actionEvent) {

        String user = username.getText();
        String pass = password.getText();


    }
}
