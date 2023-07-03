package org.example;

import java.util.Objects;
import java.util.Scanner;

public class Factory  extends Property implements Cityinterface{

    public String product;
    public float carpetprice=0.2f;
    public float clothprice=0.15f;
    public float threadprice=0.1f;

    public float productprice;
    public float output;
    public Avatar factorystaffs;


    public float salary;
    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Factory(int id, String title, String ownerID, String description, float value, float coordinate, boolean status, float output,float salary) {
        super(id, title, ownerID, description, value, coordinate, status);
        this.salary=salary;
        this.output = output;
        this.id++;
    }

    public Factory(){

    }
    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public float getProductprice() {
        return productprice;
    }

    public void setProductprice(float productprice) {
        this.productprice = productprice;
    }

    public float getOutput() {
        return output;
    }

    public void setOutput(float output) {
        this.output = output;
    }

    public Avatar getFactorystaffs() {
        return factorystaffs;
    }

    public void setFactorystaffs(Avatar factorystaffs) {
        this.factorystaffs = factorystaffs;
    }

    @Override
    public String toString() {
        return "Factory{" +
                ", output='" + output + '\'' +
                ", factorystaffs=" + factorystaffs +
                ", title='" + title + '\'' +
                ", owner-username=" + ownerusername +
                ", description='" + description + '\'' +
                ", value=" + value +
                ", coordinate=" + coordinate +
                ", status=" + status +
                '}';
    }

    @Override
    public void menu() {

    }

    @Override
    public void buy() {

    }

    @Override
    public void sell() {

    }


    public void UseProperty(String username) {


        Avatar avatar = null;
        for (Avatar i : Game.city.getAvatars()) {
            if (Objects.equals(i.getUsername(), username)) {
                avatar = i;
            }
        }
        assert avatar != null;
        avatar.setCoordinate(Game.city.getFactories().get(1).getCoordinate());
        avatar.setHealth(avatar.health -= 5);
        avatar.setFood(avatar.Food -= 5);
        avatar.setWater(avatar.Water -= 5);
        DataBase.updateInfo("avatars", "health", username, avatar.health -= 5);
        DataBase.updateInfo("avatars", "food", username, avatar.Food -= 5);
        DataBase.updateInfo("avatars", "water", username, avatar.Water -= 5);
        DataBase.updateInfo("avatars", "coordinate", username, Game.city.getFactories().get(1).getCoordinate());
        boolean check = true;

        while (check) {
            System.out.println("Which one do you want to do?");
            System.out.println("1. Buy some Carpet:");
            System.out.println("2. Buy some Cloth:");
            System.out.println("3. Buy some Thread:");
            System.out.println("4. Back to User Menu");
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            switch (n) {

                case 1:

                    System.out.println("You Bought a Carpet");
                    avatar.setMoney(avatar.money-=carpetprice);
                    DataBase.updateInfo("avatars","money",username,avatar.money-=carpetprice);
                    check=false;
                    break;

                case 2:


                    System.out.println("You Bought a Cloth");
                    avatar.setMoney(avatar.money-=clothprice);
                    DataBase.updateInfo("avatars","money",username,avatar.money-=clothprice);
                    check=false;
                    break;
                case 3:


                    System.out.println("You Bought a Thread");
                    avatar.setMoney(avatar.money-=threadprice);
                    DataBase.updateInfo("avatars","money",username,avatar.money-=threadprice);
                    check=false;
                    break;

                case 4:

                    Menu.showUserMenu();
                    check=false;
                    break;
                default:

            }
        }
    }
}
