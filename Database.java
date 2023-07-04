package org.example;

import org.example.models.User;

import javax.xml.crypto.Data;
import java.sql.*;

public class Database {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/lightcity";

    // Database credentials
    static final String USER = "root";
    static final String PASS = "2324LBJKB@pourya";


    private Connection conn;

//    public Database() {
//        try {
//            Class.forName(JDBC_DRIVER);
//            conn = DriverManager.getConnection(DB_URL, USER, PASS);
//            System.out.println("Connecting to database...");
//        } catch (Exception exp) {
//            System.out.println("Database Exception : \n" + exp.toString());
//            System.exit(0);
//        }
//    }
    //    Tables

    /**
     * Users
     */

    public void checkUserInfo(String username, String password) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/lightcity", "root", "2324LBJKB@pourya");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM user");

            boolean check = false;

            while (resultSet.next()){

                if (username.equals(resultSet.getString("username")) && password. equals(resultSet.getString("password"))){
                    check = true;
                }

            }

            if (check){



            }

        }catch (Exception e){
            System.out.println(e);
        }

    }

    public void loginGame(User user) {
        try {
            Statement stmt = conn.createStatement();
            String query = "";
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
//               Check
            }
        } catch (Exception exception) {
        }

    }

    public void registerGame(User user) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/lightcity", "root", "2324LBJKB@pourya");
            String sql = "INSERT INTO user (username, password) VALUES (?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);


            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}