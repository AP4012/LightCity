package org.example;

import java.util.Objects;
import java.util.Scanner;

public class Supermarket  extends Property implements Cityinterface{


    public String beverage;
    public String dairyProduct;
    public String snacks;
    public float beverageprice;
    public float dairyProductprice;
    public float snacksprice;
    public Avatar supermarketstaffs;


    public float salary;
    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Supermarket(int id, String title, String ownerID, String description, float value, float coordinate, boolean status,float salary) {
        super(id, title, ownerID, description, value, coordinate, status);
        this.salary=salary;
        this.id++;
    }

    public void menu(){
        // bezanim
    }

    @Override
    public void buy() {

    }

    @Override
    public void sell() {

    }

    public Supermarket(){

    }
    public void UseProperty(String username) {


        Avatar avatar = null;
        for (Avatar i : Game.city.getAvatars()) {
            if (Objects.equals(i.getUsername(), username)) {
                avatar = i;
            }
        }
        assert avatar != null;
        avatar.setCoordinate(Game.city.getRestaurants().get(1).getCoordinate());
        avatar.setHealth(avatar.health += 5);
//        avatar.setFood(avatar.Food -= 5);
//        avatar.setWater(avatar.Water -= 5);
        DataBase.updateInfo("avatars", "health", username, avatar.health += 5);
//        DataBase.updateInfo("avatars", "food", username, avatar.Food -= 5);
//        DataBase.updateInfo("avatars", "water", username, avatar.Water -= 5);
        DataBase.updateInfo("avatars", "coordinate", username, Game.city.getRestaurants().get(1).getCoordinate());
        boolean check = true;

        while (check) {
            System.out.println("Which one do you want to eat?");
            System.out.println("1. Milk:");
            System.out.println("2. Dough:");
            System.out.println("3. Yogurt:");
            System.out.println("4. Chips:");
            System.out.println("5. Cheetos:");
            System.out.println("6. Water:");
            System.out.println("7. Sparkling Water:");
            System.out.println("8. Soda pop:");
            System.out.println("9. Back to User Menu");
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            switch (n) {
                case 1:

                    DataBase.updateInfo("avatars", "water", username, avatar.Water += 50);
                    avatar.setWater(avatar.Water += 50);
                    System.out.println("You bought an Milk");
                    avatar.setMoney(avatar.money-=dairyProductprice);
                    DataBase.updateInfo("avatars","money",username,avatar.money-=dairyProductprice);
                    check=false;
                    break;

                case 2:

                    DataBase.updateInfo("avatars", "water", username, avatar.Water += 50);
                    avatar.setWater(avatar.Water += 50);
                    System.out.println("You bought an Dough");
                    avatar.setMoney(avatar.money-=dairyProductprice);
                    DataBase.updateInfo("avatars","money",username,avatar.money-=dairyProductprice);
                    check=false;
                    break;

                case 3:

                    DataBase.updateInfo("avatars", "water", username, avatar.Water += 50);
                    avatar.setWater(avatar.Water += 50);
                    System.out.println("You bought an Yogurt");
                    avatar.setMoney(avatar.money-=dairyProductprice);
                    DataBase.updateInfo("avatars","money",username,avatar.money-=dairyProductprice);
                    check=false;
                    break;

                case 4:
                    DataBase.updateInfo("avatars", "food", username, avatar.Food += 50);
                    avatar.setFood(avatar.Food += 50);
                    System.out.println("You eat an Chips");
                    avatar.setMoney(avatar.money-=snacksprice);
                    DataBase.updateInfo("avatars","money",username,avatar.money-=snacksprice);
                    check=false;
                    break;

                case 5:

                    DataBase.updateInfo("avatars", "food", username, avatar.Food += 50);
                    avatar.setFood(avatar.Food += 50);
                    System.out.println("You eat an Cheetos");
                    avatar.setMoney(avatar.money-=snacksprice);
                    DataBase.updateInfo("avatars","money",username,avatar.money-=snacksprice);
                    check=false;
                    break;

                case 6:
                    DataBase.updateInfo("avatars", "water", username, avatar.Water += 50);
                    avatar.setWater(avatar.Water += 50);
                    System.out.println("You bought an Water");
                    avatar.setMoney(avatar.money-=beverageprice);
                    DataBase.updateInfo("avatars","money",username,avatar.money-=beverageprice);
                    check=false;
                    break;
                case 7:
                    DataBase.updateInfo("avatars", "water", username, avatar.Water += 50);
                    avatar.setWater(avatar.Water += 50);
                    System.out.println("You bought an Sparkling Water");
                    avatar.setMoney(avatar.money-=beverageprice);
                    DataBase.updateInfo("avatars","money",username,avatar.money-=beverageprice);
                    check=false;
                    break;
                case 8:
                    DataBase.updateInfo("avatars", "water", username, avatar.Water += 50);
                    avatar.setWater(avatar.Water += 50);
                    System.out.println("You bought an Soda pop");
                    avatar.setMoney(avatar.money-=beverageprice);
                    DataBase.updateInfo("avatars","money",username,avatar.money-=beverageprice);
                    check=false;
                    break;
                case 9:
                    Menu.showUserMenu();
                    check=false;
                    break;
                default:
                    System.out.println("Try again");
            }
        }
    }


    public String getBeverage() {
        return beverage;
    }

    public void setBeverage(String beverage) {
        this.beverage = beverage;
    }

    public String getDairyProduct() {
        return dairyProduct;
    }

    public void setDairyProduct(String dairyProduct) {
        this.dairyProduct = dairyProduct;
    }

    public String getSnacks() {
        return snacks;
    }

    public void setSnacks(String snacks) {
        this.snacks = snacks;
    }

    public float getBeverageprice() {
        return beverageprice;
    }

    public void setBeverageprice(float beverageprice) {
        this.beverageprice = beverageprice;
    }

    public float getDairyProductprice() {
        return dairyProductprice;
    }

    public void setDairyProductprice(float dairyProductprice) {
        this.dairyProductprice = dairyProductprice;
    }

    public float getSnacksprice() {
        return snacksprice;
    }

    public void setSnacksprice(float snacksprice) {
        this.snacksprice = snacksprice;
    }

    public Avatar getSupermarketstaffs() {
        return supermarketstaffs;
    }

    public void setSupermarketstaffs(Avatar supermarketstaffs) {
        this.supermarketstaffs = supermarketstaffs;
    }

    @Override
    public String toString() {
        return "Supermarket{" +
                ", supermarketstaffs=" + supermarketstaffs +
                ", title='" + title + '\'' +
                ", owner-username=" + ownerusername +
                ", description='" + description + '\'' +
                ", value=" + value +
                ", coordinate=" + coordinate +
                ", status=" + status +
                '}';
    }
}
