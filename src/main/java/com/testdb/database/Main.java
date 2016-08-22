package com.testdb.database;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import javax.jws.soap.SOAPBinding;
import java.sql.*;

/**
 * Created by egorka on 19.08.16.
 */
public class Main {

    public static void main(String[] args) {
        DBWorker worker = new DBWorker();

        String query = "select * from users";
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet result = statement.executeQuery(query);

            while (result.next()){
                User user = new User();
                user.setId(result.getInt(1));
                user.setUsername(result.getString(2));
                user.setPassword(result.getString(3));

                System.out.println(user.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
