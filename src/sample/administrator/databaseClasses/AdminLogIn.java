package sample.administrator.databaseClasses;

import java.sql.*;

public class AdminLogIn {

    public static final String DB_NAME = "ERP.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:D:\\Database\\" + DB_NAME;

    public int searchAdmin(String user, String pass) {

        final String USER_NAME = user;
        int status = 0;
//        System.out.println("Got it");
        try{

            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();


//            statement.execute("CREATE TABLE " + TABLE_CONTACTS+
//
//                    " (" + COLUMN_NAME + " text, "+
//                    COLUMN_PHONE + "integer, " +
//                    COLUMN_EMAIL + "text" +
//                    ")");            System.out.println(user + " " + pass );

            ResultSet results = statement.executeQuery("SELECT username, password " +
                    "FROM Admin WHERE username = '" + USER_NAME+"'");

//            while (results.next())
//            {
////                System.out.println(results.getString("username") + " " +
////                        results.getString("password"));
//            }

//            System.out.println(results.getString("username") + " " +
//                        results.getString("password"));

            if (results.next())
            {
                if (pass.equals(results.getString("password")))
                    status = 3;
                else
                    status = 2;
            }
            else
                status = 1;


            statement.close();
            conn.close();
        }
        catch (SQLException e) {
            System.out.println("Something went wrong" + e.getMessage());
        }
        finally {

        }

        return status;
    }
}
