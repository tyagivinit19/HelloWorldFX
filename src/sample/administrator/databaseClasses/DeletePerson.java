package sample.administrator.databaseClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeletePerson {

    public static final String DB_NAME = "ERP.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:D:\\Database\\" + DB_NAME;

    public void delete(String userName, String branch) throws SQLException {

        Connection conn = DriverManager.getConnection(CONNECTION_STRING);
        Statement statement = conn.createStatement();

        statement.executeUpdate("DELETE " +
                "FROM " + branch +" WHERE username = '" + userName +"'");

        statement.close();
        conn.close();

    }

}
