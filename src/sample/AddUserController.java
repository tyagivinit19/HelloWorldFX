package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.databaseClasses.AddUser;

import java.io.IOException;

public class AddUserController {

    public TextField userName;
    public TextField name;
    public TextField address;
    public TextField phone;
    public PasswordField password;
    public PasswordField cPassword;
    public Label msg;
    public AnchorPane aU;
    public ChoiceBox choiceBox;

    public void submit(ActionEvent actionEvent) throws IOException {

        String userName = this.userName.getText();
        String name = this.name.getText();
        String address = this.address.getText();
        String phone = this.phone.getText();
        String password = this.password.getText();
        String cPassword = this.cPassword.getText();


        String branch = (String) choiceBox.getValue();
//        System.out.println(s);




        int count = 0;

        if (userName.isBlank())
        {
            msg.setText("Enter the username.");
            count++;
        }
        else
        {
            if (name.isBlank())
            {
                msg.setText("Enter the name.");
                count++;
            }
            else
            {
                if (address.isBlank())
                {
                    msg.setText("Enter the address");
                    count++;
                }
                else
                {
                    if (phone.isBlank())
                    {
                        msg.setText("Enter the Phone No.");
                        count++;
                    }
                    else
                    {
                        if (password.isBlank())
                        {
                            msg.setText("Enter the Password.");
                            count++;
                        }
                        else
                        {
                            if (cPassword.isBlank())
                            {
                                msg.setText("Enter the confirm password.");
                                count++;
                            }
                            else
                            {
                                if (!password.equals(cPassword))
                                {
                                    msg.setText("Password is Mismatched.");
                                    count++;
                                }
                                else
                                {
//                                    count=0;
                                    if (branch.equals("null"))
                                    {
                                        msg.setText("Choose a Branch for User.");
                                    }
                                    else
                                    {
                                        count = 0;
                                    }
                                }
                            }

                        }
                    }
                }
            }
        }

        if (count == 0)
        {
            AddUser ob = new AddUser();
            boolean status = ob.add(userName, name, address, phone, password, branch);

            if (status)
            {
                Parent newroot = FXMLLoader.load(getClass().getResource("addSucess.fxml"));

                Stage stage = (Stage) aU.getScene().getWindow();
                stage.setScene(new Scene(newroot));
                stage.show();
            }
        }


    }
}
