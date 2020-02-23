package sample.databaseClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AddUser {
    public static final String DB_NAME = "ERP.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:D:\\Database\\" + DB_NAME;


    public boolean add (String userName, String name,
                     String address, String phone, String password)
    {
        boolean k = false;
        try
        {
            System.out.println("well done");
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();


            statement.execute("INSERT INTO User (userName, name, address, phone, password)" +
                    "VALUES('" + userName + "','" + name + "','" + address + "'," +
                    "'" + phone + "','" + password +"')");

            statement.close();
            conn.close();
            k = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return k;
    }
}
