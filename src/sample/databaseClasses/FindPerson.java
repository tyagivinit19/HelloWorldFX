package sample.databaseClasses;

import sample.ShowDetailsController;

import java.sql.*;

public class FindPerson {

    public static final String DB_NAME = "ERP.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:D:\\Database\\" + DB_NAME;


    public String find(String userName, String branch) {

        String status = null ;

        if (userName.isBlank())
        {
            status = "u";
        }
        else
        {
            if (branch == null)
            {
                status = "b";
            }
            else
            {
                try
                {
                    System.out.println("well done");
                    Connection conn = DriverManager.getConnection(CONNECTION_STRING);
                    Statement statement = conn.createStatement();

                    ResultSet results = statement.executeQuery("SELECT username, name " +
                            "FROM " + branch +" WHERE username = '" + userName +"'");


                    if (results.next())
                    {
                        System.out.println("Found");
                        status = results.getString("name");
//                        System.out.println(results);

                    }
                    else
                    {
                        System.out.println("Not Found");
                        status = "nF";
                    }

//            statement.execute("DELETE FROM " + branch + " WHERE username = '" + userName + "'");

                    statement.close();
                    conn.close();

                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }


        return status;
    }

    public void personDetails(ShowDetailsController showDetailsController) throws SQLException {
        System.out.println(showDetailsController.userName.getText()+"P");
        Connection conn = DriverManager.getConnection(CONNECTION_STRING);
        Statement statement = conn.createStatement();

        ResultSet results = statement.executeQuery("SELECT * " +
                "FROM " + showDetailsController.branch.getText() +" WHERE username = '" +
                showDetailsController.userName.getText() +"'");

//        System.out.println(results.getString("name"));
//        System.out.println(results.getString("phone"));

        String name = results.getString("name");
        String address = results.getString("address");
        String phone = results.getString("phone");

        showDetailsController.showDetails(name, address, phone);



    }
}
