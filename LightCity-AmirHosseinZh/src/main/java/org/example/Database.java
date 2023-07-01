package org.example;

import org.example.models.*;
import com.sun.tools.javac.Main;
import org.example.models.Character;
import org.example.models.Property;
import org.example.models.User;
import org.example.defualtSystem.*;

import javax.xml.crypto.Data;

import org.example.Database;

import java.sql.*;
import java.util.ArrayList;

public class Database {


    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/lightCity";

    // Database credentials
    static final String USER = "root";
    static final String PASS = "hossein1383";

    public static ArrayList<Character> characters = new ArrayList<>();
    private static Connection conn;

    public Database() {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connecting to database...");
        } catch (Exception exp) {
            System.out.println("Database Exception : \n" + exp.toString());
            System.exit(0);
        }
    }

    public static void updateCharacter(String status, Character character) {
        String updateQuery = "";
        switch (status) {
            case "location":
                updateQuery = "UPDATE characters SET location = ? WHERE username = ?";
                break;
            case "job":
                updateQuery = "UPDATE characters SET job = ? WHERE username = ?";
                break;
            case "life":
                updateQuery = "UPDATE characters SET life = ? WHERE username = ?";
                break;
            case "money":
                updateQuery = "UPDATE characters SET money = ? WHERE username = ?";
                break;
            default:
                System.out.println("Invalid status: " + status);
                return;
        }

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement statement = connection.prepareStatement(updateQuery)) {

            switch (status) {
                case "location":
                    String location = character.getInPosition() != null ?
                            character.getInPosition().getCoordinate()[0] + "," + character.getInPosition().getCoordinate()[1] :
                            "null";
                    statement.setString(1, location);
                    break;
                case "job":
                    statement.setString(1, character.getJob().getTitle());
                    break;
                case "life":
                    Life life = character.getLife();
                    String lifeDetails = life.getFood() + "," + life.getSleep() + "," + life.getWater();
                    statement.setString(1, lifeDetails);
                    break;
                case "money":
                    BankAccount bankAccount = character.getAccount();
                    statement.setFloat(1, bankAccount.getMoney());
                    break;
            }

            statement.setString(2, character.getUserInfo().getUsername());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    //    Tables

    /**
     * Users
     */

    private void createTables() {
//        query example
        String query = "CREATE TABLE IF NOT EXISTS Users (username varchar(255) primary key ,password varchar(255));" +
                "CREATE TABLE IF NOT EXISTS ....";
        try {
            Statement stmt = conn.createStatement();
            if (stmt.execute(query)) {

            } else
                System.out.println("An error accord during operation");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    static String userName;
    static String passWord;

    public static User loginGame(User user) {

        try {
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM lightCity";
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                userName = res.getString(1);
                passWord = res.getString(2);
                if (user.getUsername().equals(userName) && user.getPassword().equals(passWord)) {
                    return user;
                }
            }
        } catch (Exception exception) {
        }
        return null;
    }

    public static boolean notNull(User user) {
        try {
            Statement statement = conn.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM users");
            if (res.next()) {
                return false;
            } else
                return true;
        } catch (Exception e) {
        }
        return false;
    }

    public static User registerGame(User user) {
        boolean isNotNull = notNull(user);
        if (!isNotNull) {
            try {
                Statement statement = conn.createStatement();
                String query = String.format("INSERT INTO lightCity(username,password) VALUES(%s,%s)", user.getUsername(), user.getPassword());
            } catch (Exception e) {
            }
        }
        return null;
    }

    public static void saveProperties(Property property) {
        String query = "INSERT INTO properties(width , height,coordinate1,coordinate2,owner) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            float width = property.getScales()[0];
            float height = property.getScales()[1];
            float xCoordinate = property.getCoordinate()[0];
            float yCoordinate = property.getScales()[1];
            preparedStatement.setFloat(1, width);
            preparedStatement.setFloat(2, height);
            preparedStatement.setFloat(3, xCoordinate);
            preparedStatement.setFloat(4, yCoordinate);
            if (property.getOwner() == null) {
                preparedStatement.setString(5, "defaultOwner");
            } else
                preparedStatement.setString(5, property.getOwner().toString());
            preparedStatement.executeUpdate();
        } catch (Exception e) {

        }

    }

    public static void saveCharacter(Character character) {
        String insertQuery = "INSERT INTO `characters`(`username`, `password`, `money`, `life`, `job`, `location`) VALUES (?,?,?,?,?,?)";

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement statement = connection.prepareStatement(insertQuery)) {

            String username = character.getUserInfo().getUsername();
            String password = character.getUserInfo().getPassword();
            String life = character.getLife().getFood() + "," + character.getLife().getSleep() + "," + character.getLife().getWater();
            String jobTitle = "";
            if (character.getJob() == null) {
                jobTitle = "null";
            } else {
                jobTitle = character.getJob().getTitle();
            }
            String inLocation = " ";

            if (character.getInPosition() == null) {
                inLocation = "null";
            } else {
                inLocation = character.getInPosition().getCoordinate()[0] + "," + character.getInPosition().getCoordinate()[1];
            }

            statement.setString(1, username);
            statement.setString(2, password);
            statement.setFloat(3, character.getAccount().getMoney());
            statement.setString(4, life);
            statement.setString(5, jobTitle);
            statement.setString(6, inLocation);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Property> getProperties() {
        ArrayList<Property> getPropertiesList = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM properties");
            while (resultSet.next()) {
                float width = resultSet.getFloat("width");
                float height = resultSet.getFloat("height");
                float xCoordinate = resultSet.getFloat("xCoordinate");
                float yCoordinate = resultSet.getFloat("yCoordinate");
                Property property = new Property(new float[]{width, height}, new float[]{xCoordinate, yCoordinate}, null);
                getPropertiesList.add(property);
            }
            return getPropertiesList;
        } catch (Exception e) {

        }
        return getPropertiesList;
    }

    public static void createBankAccount(BankAccount bankAccount) {
        String insertQuery = "INSERT INTO `bank-account`(`username`, `password`, `money`, `last`) VALUES (?,?,?,?)";

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement statement = connection.prepareStatement(insertQuery)) {

            String username = bankAccount.getOwner();
            String password = bankAccount.getPassword();
            float money = bankAccount.getMoney();
            String last = bankAccount.getLastChange().toString();
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setFloat(3, money);
            statement.setString(4, last);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
