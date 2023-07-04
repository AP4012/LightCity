package org.example;

import org.example.models.User;

import javax.xml.crypto.Data;
import java.security.spec.ECField;
import java.sql.*;
import java.util.Scanner;

import java.security.*;

public class Database {

    int id;
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/lightcity";

    // Database credentials
    static final String USER = "root";
    static final String PASS = "2324LBJKB@pourya";


    private Connection conn;

    public Database() {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("\nConnecting to database...");
        } catch (Exception exp) {
            System.out.println("Database Exception : \n" + exp.toString());
            System.exit(0);
        }
    }
    //    Tables

    /**
     * Users
     */

    public void checkUserInfo(String username, String password) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lightcity", "root", "2324LBJKB@pourya");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM user");

            boolean check = false;

            password = encryptPassword(password);

            while (resultSet.next()){

                if (username.equals(resultSet.getString("username")) && password.equals(resultSet.getString("password"))){
                    check = true;
                }

            }

            if (check){

                System.out.println("\nWelcome!");
                System.out.println("\n1. Enter a city");
                System.out.println("2. Build a new city");

                System.out.print("\nInput number: ");

                Scanner sc = new Scanner(System.in);

                int num;
                num = sc.nextInt();

                if (num == 1) {
                    cityList(username, password);

                } else if (num == 2) {
                    buildCity(username, password);

                }


            } else {

                System.out.println("\nYou have not registered yet. Would you like to register now?");
                System.out.println("\n1. Yes");
                System.out.println("2. No");
                System.out.print("\nInput number: ");

                Scanner sc = new Scanner(System.in);

                int num;
                num = sc.nextInt();

                if (num == 1) {

                    Scanner str = new Scanner(System.in);

                    String userName;
                    String passWord;

                    System.out.print("\nUsername: ");
                    userName = str.nextLine();

                    System.out.print("Password: ");
                    passWord = str.nextLine();

                    passWord = encryptPassword(passWord);

                    User user = new User(userName, passWord);

                    registerGame(user);

                    System.out.println("\nYou have successfully registered.\n");

                } else if (num == 2) {
                    Menu.showMenu();
                }
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
            String sql = "INSERT INTO user (id, username, password) VALUES (?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPassword());

            preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String encryptPassword(String password){

        String encryptedPassword = null;

        try {

            MessageDigest m = MessageDigest.getInstance("MD5");

            m.update(password.getBytes());

            byte[] bytes = m.digest();

            StringBuilder s = new StringBuilder();

            for (int i = 0; i < bytes.length; i++) {
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            encryptedPassword = s.toString();

        } catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }

        return encryptedPassword;

    }

    public void cityList(String username, String password){

        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lightcity", "root", "2324LBJKB@pourya");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM city");



            System.out.println("\nList of available cities:");

            while (resultSet.next()){

                int cityID;
                String manager;
                String cityName;


                cityID = resultSet.getInt("id");
                manager = resultSet.getString("manager");
                cityName = resultSet.getString("name");

                System.out.println("\nCity name: " + cityName);
                System.out.println("Manager: " + manager);
                System.out.println("City ID: " + cityID);

                System.out.println("\n------------------------------------------");

            }

            Scanner sc = new Scanner(System.in);

            System.out.print("\nEnter the ID of the city you want to enter: ");

            int cityID;
            cityID = sc.nextInt();

            cityLogin(cityID);

        } catch (Exception e){

            System.out.println("\nNo city has been created yet!");
            System.out.println("Do you want to build a new city?");

            System.out.println("\n1. Yes");
            System.out.println("2. No");

            System.out.print("\nInput number: ");

            Scanner numSC = new Scanner(System.in);

            int num2;
            num2 = numSC.nextInt();

            if (num2 == 1) {

                buildCity(username, password);

            } else if (num2 == 2) {
                Menu.showMenu();
            }

        }

    }

    public void buildCity(String username, String password){

        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter the name of the city: ");

        String cityName;
        cityName = sc.nextLine();



        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/lightcity", "root", "2324LBJKB@pourya");
            String sql = "INSERT INTO city (id, manager, name, password, industry, income, product) VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, id);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, cityName);
            preparedStatement.setString(4, password);
            preparedStatement.setString(5, null);
            preparedStatement.setString(6, null);
            preparedStatement.setString(7, null);

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("\nCity has been built successfully!");

    }

    public void cityLogin(int cityID){

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lightcity", "root", "2324LBJKB@pourya");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM city");

            while (resultSet.next()){

                if (cityID == resultSet.getInt("id")){
                    cityMenu(resultSet.getString("name"), cityID);
                }
            }

        } catch (Exception e){
            System.out.println(e);
        }

    }

    public void cityMenu(String cityName, int cityID){

        System.out.println("\nCity name: " + cityName);

        System.out.println("\n1. Go to");
        System.out.println("2. Process Location");
        System.out.println("3. Dashboard");
        System.out.println("4. Build a new industry");
        System.out.println("5. Life");
        System.out.println("6. Exit");

        System.out.print("Input number: ");

        Scanner sc = new Scanner(System.in);

        int num;
        num = sc.nextInt();

        switch (num){

            case 1:
                break;

            case  2:
                break;

            case 3:
                break;

            case 4:
                buildIndustry(cityName, cityID);
                break;

            case 5:
                break;

            case 6:
                System.exit(0);
                break;

        }
    }

    public void buildIndustry(String cityName, int cityID){

        Scanner sc = new Scanner(System.in);

        String title;
        String income;
        String product;

        System.out.print("\nEnter the title of the industry: ");
        title = sc.nextLine();

        System.out.print("Product: ");
        product = sc.nextLine();

        System.out.print("Income: ");
        income = sc.nextLine();

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/lightcity", "root", "2324LBJKB@pourya");
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE city set industry = ?, income = ?, product = ? WHERE id = ?");

            preparedStatement.setString(1, title);
            preparedStatement.setString(2, income);
            preparedStatement.setString(3, product);
            preparedStatement.setInt(4, cityID);

            preparedStatement.executeUpdate();

        }catch (Exception e){
            System.out.println(e);
        }

        System.out.println("\nIndustry has been created successfully!");

        cityMenu(cityName, cityID);

    }

}
