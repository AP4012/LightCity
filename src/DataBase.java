package org.example;

import java.sql.*;
import java.util.Objects;

public class DataBase {
    static Connection connection;
    static Statement statement;
    static ResultSet resultSet;

    public static boolean doctor=true;
    public static boolean nurse=true;

    DataBase() {
        try {
            String url = "jdbc:mysql://localhost:3306/lightcity";
            connection = DriverManager.getConnection(url, "root", "1382");
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }

    }


    public  void selectAll(City city) {

        try {
            resultSet = statement.executeQuery("select * from avatars");
//          (int id,String username, String password, String title, String gender, float money, float health,int sleep,String job)
            while (resultSet.next()) {
//                System.out.println("check");
                city.getAvatars().add(new Avatar( resultSet.getString(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4), resultSet.getFloat(5), resultSet.getFloat(6),
                        resultSet.getInt(7), resultSet.getString(8),resultSet.getFloat(9),resultSet.getFloat(10),resultSet.getFloat(11),resultSet.getInt(12),resultSet.getFloat(13)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            resultSet = statement.executeQuery("select * from bank");
//          (int id, String title, int ownerID, String description, float value, float[] coordinate, boolean status, int prayerID, int recieverID, int transactionID, float amountofMoney, Avatar[] bankstaffs)
            while (resultSet.next()) {
//                System.out.println("check");

                city.getBanks().add(new Bank(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getFloat(5), resultSet.getFloat(6), resultSet.getBoolean(7),resultSet.getFloat(8)));
                Property property=new Property(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getFloat(5), resultSet.getFloat(6), resultSet.getBoolean(7));
                city.getProperties().add(property);
            }

//            Property.setId(city.getBanks().size()+city.getBoutiques().size()+city.getClinics().size()+city.getFactories().size()+city.getHomes().size()+city.getLands().size()+city.getRestaurants().size()+city.getSupermarkets().size()+1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            resultSet = statement.executeQuery("select * from boutique");
//          (int id, String title, int ownerID, String description, float value, float[] coordinate, boolean status, String dress, float dressprice, String shoe, float shoeprice, String hat, float hatprice, Avatar[] boutiquestaffs)
            while (resultSet.next()) {
//                System.out.println("check");


                city.getBoutiques().add(new Boutique(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getFloat(5), resultSet.getFloat(6), resultSet.getBoolean(7),resultSet.getFloat(8)));
                Property property=new Property(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getFloat(5), resultSet.getFloat(6), resultSet.getBoolean(7));
                city.getProperties().add(property);
            }
//            Property.setId(city.getBanks().size()+city.getBoutiques().size()+city.getClinics().size()+city.getFactories().size()+city.getHomes().size()+city.getLands().size()+city.getRestaurants().size()+city.getSupermarkets().size()+1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            resultSet = statement.executeQuery("select * from clinic");
//          (int id, String title, int ownerID, String description, float value, float[] coordinate, boolean status, Avatar[] doctors, Avatar[] nurses, Avatar[] patient, float clinicprice)
            while (resultSet.next()) {
//                System.out.println("check");

                Avatar avatar1 = null;
                for(Avatar i : city.getAvatars()){
                    if(Objects.equals(i.getUsername(), resultSet.getString(8))){
                        avatar1 = i;
                    }
                }
                Avatar avatar2 = null;
                for(Avatar i : city.getAvatars()){
                    if(Objects.equals(i.getUsername(), resultSet.getString(9))){
                        avatar2 = i;
                    }
                }

                if (resultSet.getString(9)==null|| Objects.equals(resultSet.getString(9), "")){
                    nurse=false;
                }
                if (resultSet.getString(8)==null||Objects.equals(resultSet.getString(8), "")){
                    doctor=false;
                }

                city.getClinics().add(new Clinic(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getFloat(5), resultSet.getFloat(6), resultSet.getBoolean(7),
                        avatar1,avatar2,resultSet.getFloat(10)));

                Property property=new Property(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getFloat(5), resultSet.getFloat(6), resultSet.getBoolean(7));
                city.getProperties().add(property);
            }
 //           Property.setId(city.getBanks().size()+city.getBoutiques().size()+city.getClinics().size()+city.getFactories().size()+city.getHomes().size()+city.getLands().size()+city.getRestaurants().size()+city.getSupermarkets().size()+1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            resultSet = statement.executeQuery("select * from factory");
//          (int id, String title, int ownerID, String description, float value, float[] coordinate, boolean status, String product, float productprice, String output, Avatar[] factorystaffs)
            while (resultSet.next()) {
//                System.out.println("check");

//                Avatar avatar = null;
//                for(Avatar i : city.getAvatars()){
//                    if(Objects.equals(i.getUsername(), resultSet.getString(9))){
//                        avatar = i;
//                    }
//                }

                city.getFactories().add(new Factory(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getFloat(5), resultSet.getFloat(6), resultSet.getBoolean(7),
                        resultSet.getFloat(8),resultSet.getFloat(9)));
                Property property=new Property(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getFloat(5), resultSet.getFloat(6), resultSet.getBoolean(7));
                city.getProperties().add(property);
            }
//            Property.setId(city.getBanks().size()+city.getBoutiques().size()+city.getClinics().size()+city.getFactories().size()+city.getHomes().size()+city.getLands().size()+city.getRestaurants().size()+city.getSupermarkets().size()+1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            resultSet = statement.executeQuery("select * from home");
//          (int id, String title, int ownerID, String description, float value, float[] coordinate, boolean status, String kind, String roomNo, int age)
            while (resultSet.next()) {
//                System.out.println("check");
                city.getHomes().add(new Home(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getFloat(5),resultSet.getFloat(6), resultSet.getBoolean(7),
                        resultSet.getString(8), resultSet.getInt(9),resultSet.getInt(10)));
                Property property=new Property(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getFloat(5), resultSet.getFloat(6), resultSet.getBoolean(7));
                city.getProperties().add(property);
            }
 //           Property.setId(city.getBanks().size()+city.getBoutiques().size()+city.getClinics().size()+city.getFactories().size()+city.getHomes().size()+city.getLands().size()+city.getRestaurants().size()+city.getSupermarkets().size()+1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            resultSet = statement.executeQuery("select * from land");
//          (int id, String title, int ownerID, String description, float value, float[] coordinate, boolean status , String kind, boolean status_for_use)
            while (resultSet.next()) {
//                System.out.println("check");
                city.getLands().add(new Land(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getFloat(5), resultSet.getFloat(6), resultSet.getBoolean(7),
                        resultSet.getString(8), resultSet.getBoolean(9)));
                Property property=new Property(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getFloat(5), resultSet.getFloat(6), resultSet.getBoolean(7));
                city.getProperties().add(property);
            }
 //           Property.setId(city.getBanks().size()+city.getBoutiques().size()+city.getClinics().size()+city.getFactories().size()+city.getHomes().size()+city.getLands().size()+city.getRestaurants().size()+city.getSupermarkets().size()+1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            resultSet = statement.executeQuery("select * from restaurant");
//          (int id, String title, int ownerID, String description, float value, float[] coordinate, boolean status, String[] food, String[] drink, float foodprice, float drinkprice, Avatar[] restaurantstaffs)
            while (resultSet.next()) {
//                System.out.println("check");


                city.getRestaurants().add(new Restaurant(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getFloat(5), resultSet.getFloat(6), resultSet.getBoolean(7),resultSet.getFloat(8)));
                Property property=new Property(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getFloat(5), resultSet.getFloat(6), resultSet.getBoolean(7));
                city.getProperties().add(property);
            }
 //           Property.setId(city.getBanks().size()+city.getBoutiques().size()+city.getClinics().size()+city.getFactories().size()+city.getHomes().size()+city.getLands().size()+city.getRestaurants().size()+city.getSupermarkets().size()+1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            resultSet = statement.executeQuery("select * from supermarket");
//          (int id, String title, int ownerID, String description, float value, float[] coordinate, boolean status, String[] beverage, String[] dairyProduct, String[] snacks, float beverageprice, float dairyProductprice, float snacksprice, Avatar[] supermarketstaffs)
            while (resultSet.next()) {
//                System.out.println("check");


                city.getSupermarkets().add(new Supermarket(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getFloat(5), resultSet.getFloat(6), resultSet.getBoolean(7),resultSet.getFloat(8)));
                Property property=new Property(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getFloat(5), resultSet.getFloat(6), resultSet.getBoolean(7));
                city.getProperties().add(property);
            }

 //           Property.setId(city.getBanks().size()+city.getBoutiques().size()+city.getClinics().size()+city.getFactories().size()+city.getHomes().size()+city.getLands().size()+city.getRestaurants().size()+city.getSupermarkets().size()+1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            resultSet = statement.executeQuery("select * from property");
//          (int id,String title,int ownerID,String description,float value,float coordinate,boolean status)
            while (resultSet.next()) {
//                System.out.println("check");

                city.getProperties().add(new Property(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getFloat(5), resultSet.getFloat(6), resultSet.getBoolean(7)));
                Property property=new Property(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getFloat(5), resultSet.getFloat(6), resultSet.getBoolean(7));
                city.getProperties().add(property);
            }
  //          Property.setId(city.getProperties().size()+1);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void saveAvatars(City city,Avatar avatar){

        city.getAvatars().add(avatar);

        try{
            PreparedStatement ps = connection.prepareStatement("insert into avatars ( username, password, title,  gender, money, health, sleep, job,coordinate,food,income, industryid,water)"+
                    "values (?,?,?,?,?,?,?,?,?,?,?,?,?)");

            ps.setString(1, avatar.getUsername());
            ps.setString(2, avatar.getPassword());
            ps.setString(3, avatar.getTitle());
            ps.setString(4, avatar.getGender());
            ps.setFloat(5, avatar.getMoney());
            ps.setFloat(6, avatar.getHealth());
            ps.setInt(7, avatar.getSleep());
            ps.setString(8, avatar.getJob());
            ps.setFloat(9,avatar.getCoordinate());
            ps.setFloat(10,avatar.getFood());
            ps.setFloat(11,avatar.getIncome());
            ps.setInt(12,avatar.getIndustryid());
            ps.setFloat(13, avatar.getWater());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    public static void saveBank(City city,Bank bank){

        city.getBanks().add(bank);



        try{

            PreparedStatement ps = connection.prepareStatement("insert into bank ( id,  title, ownerID,  description, value,  coordinate, status,salary)"+
                    "values (?,?,?,?,?,?,?,?)");

            ps.setInt(1, bank.getId());
            ps.setString(2, bank.getTitle());
            ps.setString(3, bank.getOwnerusername());
            ps.setString(4, bank.getDescription());
            ps.setFloat(5, bank.getValue());
            ps.setFloat(6, bank.getCoordinate());
            ps.setBoolean(7, bank.isStatus());
            ps.setFloat(8,bank.getSalary());
//            ps.setString(8,bank.getBankstaffs().getUsername() );
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void saveBoutique(City city,Boutique boutique){

        city.getBoutiques().add(boutique);

        try{
            PreparedStatement ps = connection.prepareStatement("insert into boutique ( id,  title, ownerID,  description, value,  coordinate, status,salary)"+
                    "values (?,?,?,?,?,?,?,?)");

            ps.setInt(1, boutique.getId());
            ps.setString(2, boutique.getTitle());
            ps.setString(3, boutique.getOwnerusername());
            ps.setString(4, boutique.getDescription());
            ps.setFloat(5, boutique.getValue());
            ps.setFloat(6, boutique.getCoordinate());
            ps.setBoolean(7, boutique.isStatus());
            ps.setFloat(8,boutique.getSalary());
//            ps.setString(8, boutique.getBoutiquestaffs().getUsername());
            ps.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }
    }


    public static void saveClinic(City city,Clinic clinic){

        city.getClinics().add(clinic);

        try{

            PreparedStatement ps = connection.prepareStatement("insert into clinic ( id,  title, ownerID,  description, value,  coordinate, status,doctorsid, nursesid,salary)"+
                    "values (?,?,?,?,?,?,?,?,?,?)");

            ps.setInt(1, clinic.getId());
            ps.setString(2, clinic.getTitle());
            ps.setString(3, clinic.getOwnerusername());
            ps.setString(4, clinic.getDescription());
            ps.setFloat(5, clinic.getValue());
            ps.setFloat(6, clinic.getCoordinate());
            ps.setBoolean(7, clinic.isStatus());
            ps.setString(8, clinic.getDoctors().getUsername());
            ps.setString(9, clinic.getNurses().getUsername());
            ps.setFloat(10,clinic.getSalary());
            ps.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void saveFactory(City city,Factory factory){

        city.getFactories().add(factory);

        try{

            PreparedStatement ps = connection.prepareStatement("insert into factory ( id,  title, ownerID,  description, value,  coordinate, status,output,salary)"+
                    "values (?,?,?,?,?,?,?,?,?)");

            ps.setInt(1, factory.getId());
            ps.setString(2, factory.getTitle());
            ps.setString(3, factory.getOwnerusername());
            ps.setString(4, factory.getDescription());
            ps.setFloat(5, factory.getValue());
            ps.setFloat(6, factory.getCoordinate());
            ps.setBoolean(7, factory.isStatus());
            ps.setFloat(8, factory.getOutput());
            ps.setFloat(9,factory.getSalary());
//            ps.setString(9, factory.getFactorystaffs().getUsername());
            ps.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void saveHome(City city,Home home){

        city.getHomes().add(home);

        try{

            PreparedStatement ps = connection.prepareStatement("insert into home ( id,  title, ownerID,  description, value,  coordinate, status,  kind,  roomNo,  age)"+
                    "values (?,?,?,?,?,?,?,?,?,?)");

            ps.setInt(1, home.getId());
            ps.setString(2, home.getTitle());
            ps.setString(3, home.getOwnerusername());
            ps.setString(4, home.getDescription());
            ps.setFloat(5, home.getValue());
            ps.setFloat(6, home.getCoordinate());
            ps.setBoolean(7, home.isStatus());
            ps.setString(8, home.getKind());
            ps.setInt(9, home.getRoomNo());
            ps.setInt(10, home.getAge());
            ps.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void saveLand(City city,Land land){

        city.getLands().add(land);

        try{

            PreparedStatement ps = connection.prepareStatement("insert into land ( id,  title, ownerID,  description, value,  coordinate, status,  kind, status_for_use)"+
                    "values (?,?,?,?,?,?,?,?,?)");

            ps.setInt(1, land.getId());
            ps.setString(2, land.getTitle());
            ps.setString(3, land.getOwnerusername());
            ps.setString(4, land.getDescription());
            ps.setFloat(5, land.getValue());
            ps.setFloat(6, land.getCoordinate());
            ps.setBoolean(7, land.isStatus());
            ps.setString(8, land.getKind());
            ps.setBoolean(9, land.isStatus_for_use());
            ps.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void saveRestaurant(City city,Restaurant restaurant){

        city.getRestaurants().add(restaurant);

        try{

            PreparedStatement ps = connection.prepareStatement("insert into restaurant ( id,  title, ownerID,  description, value,  coordinate, status,salary)"+
                    "values (?,?,?,?,?,?,?,?)");

            ps.setInt(1, restaurant.getId());
            ps.setString(2, restaurant.getTitle());
            ps.setString(3, restaurant.getOwnerusername());
            ps.setString(4, restaurant.getDescription());
            ps.setFloat(5, restaurant.getValue());
            ps.setFloat(6, restaurant.getCoordinate());
            ps.setBoolean(7, restaurant.isStatus());
            ps.setFloat(8,restaurant.getSalary());
//            ps.setString(8, restaurant.getRestaurantstaffs().getUsername());
            ps.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void saveSupermarket(City city,Supermarket supermarket){

        city.getSupermarkets().add(supermarket);

        try{

            PreparedStatement ps = connection.prepareStatement("insert into supermarket ( id,  title, ownerID,  description, value,  coordinate, status,salary)"+
                    "values (?,?,?,?,?,?,?,?)");

            ps.setInt(1, supermarket.getId());
            ps.setString(2, supermarket.getTitle());
            ps.setString(3, supermarket.getOwnerusername());
            ps.setString(4, supermarket.getDescription());
            ps.setFloat(5, supermarket.getValue());
            ps.setFloat(6, supermarket.getCoordinate());
            ps.setBoolean(7, supermarket.isStatus());
            ps.setFloat(8,supermarket.getSalary());
//            ps.setString(8, supermarket.getSupermarketstaffs().getUsername());
            ps.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void saveProperty(City city,Property property){
        city.getProperties().add(property);
        try{

            PreparedStatement ps = connection.prepareStatement("insert into property ( id,  title, ownerID,  description, value,  coordinate, status)"+
                    "values (?,?,?,?,?,?,?)");

            ps.setInt(1, property.getId());
            ps.setString(2, property.getTitle());
            ps.setString(3, property.getOwnerusername());
            ps.setString(4, property.getDescription());
            ps.setFloat(5, property.getValue());
            ps.setFloat(6, property.getCoordinate());
            ps.setBoolean(7, property.isStatus());
            ps.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void updateInfo(String changeClass, String element , int id, String newValue){
        try {
            PreparedStatement ps = connection.prepareStatement("update "+changeClass+" set "+element+" = ? where id = ?");
            ps.setString(1, newValue);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void updateInfo(String changeClass, String element , int id, Boolean newValue){
        try {
            PreparedStatement ps = connection.prepareStatement("update "+changeClass+" set "+element+" = ? where id = ?");
            ps.setBoolean(1, newValue);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void updateInfo(String changeClass, String element , int id, long newValue){
        try {
            PreparedStatement ps = connection.prepareStatement("update "+changeClass+" set "+element+" = ? where id = ?");
            ps.setLong(1, newValue);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void updateInfo(String changeClass, String element , String username, String newValue){
        try {
            PreparedStatement ps = connection.prepareStatement("update "+changeClass+" set "+element+" = ? where username = ?");
            ps.setString(1, newValue);
            ps.setString(2, username);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void updateInfo(String changeClass, String element , String username, float newValue){
        try {
            PreparedStatement ps = connection.prepareStatement("update "+changeClass+" set "+element+" = ? where username = ?");
            ps.setFloat(1, newValue);
            ps.setString(2, username);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void updateInfo(String changeClass, String element , int id, float newValue){
        try {
            PreparedStatement ps = connection.prepareStatement("update "+changeClass+" set "+element+" = ? where id = ?");
            ps.setFloat(1, newValue);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}





