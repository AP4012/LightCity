package org.example;

import java.util.Objects;
import java.util.Scanner;

public class Boutique extends Property implements Cityinterface{

    public String dress;
    public static float dressprice=0.5f;
    public String shoe;
    public static float shoeprice=0.25f;
    public String hat;
    public static float hatprice=0.1f;
    public Avatar Boutiquestaffs;

    public float salary;

    public Boutique(int id, String title, String ownerID, String description, float value, float coordinate, boolean status,float salary) {
        super(id, title, ownerID, description, value, coordinate, status);
        this.salary=salary;
        this.id++;
    }

    public Boutique(){

    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getDress() {
        return dress;
    }

    public void setDress(String dress) {
        this.dress = dress;
    }

    public float getDressprice() {
        return dressprice;
    }

    public void setDressprice(float dressprice) {
        this.dressprice = dressprice;
    }

    public String getShoe() {
        return shoe;
    }

    public void setShoe(String shoe) {
        this.shoe = shoe;
    }

    public float getShoeprice() {
        return shoeprice;
    }

    public void setShoeprice(float shoeprice) {
        this.shoeprice = shoeprice;
    }

    public String getHat() {
        return hat;
    }

    public void setHat(String hat) {
        this.hat = hat;
    }

    public float getHatprice() {
        return hatprice;
    }

    public void setHatprice(float hatprice) {
        this.hatprice = hatprice;
    }

    public Avatar getBoutiquestaffs() {
        return Boutiquestaffs;
    }

    public void setBoutiquestaffs(Avatar boutiquestaffs) {
        Boutiquestaffs = boutiquestaffs;
    }

    @Override
    public String toString() {
        return "Boutique{" +
                ", Boutiquestaffs=" + Boutiquestaffs +
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
    public void UseProperty(String username) {

        Avatar avatar = null;
        for (Avatar i : Game.city.getAvatars()) {
            if (Objects.equals(i.getUsername(), username)) {
                avatar = i;
            }
        }
        assert avatar != null;
        avatar.setCoordinate(Game.city.getBoutiques().get(1).getCoordinate());
        avatar.setHealth(avatar.health-=5);
        avatar.setFood(avatar.Food-=5);
        avatar.setWater(avatar.Water-=5);
        DataBase.updateInfo("avatars","health",username,avatar.health-=5);
        DataBase.updateInfo("avatars","food",username,avatar.Food-=5);
        DataBase.updateInfo("avatars","water",username,avatar.Water-=5);
        DataBase.updateInfo("avatars","coordinate",username,Game.city.getBoutiques().get(1).getCoordinate());
        boolean check=true;
        while (check){
            System.out.println("Which one do you want to buy?");
            System.out.println("1. Dress");
            System.out.println("2. Shoe");
            System.out.println("3. Hat");
            System.out.println("4. Back to User Menu");
            Scanner scanner=new Scanner(System.in);
            int n=scanner.nextInt();
            switch (n){
                case 1:
                    System.out.println("You bought some Dress");
                    avatar.setMoney(avatar.money-=dressprice);
                    DataBase.updateInfo("avatars","money",username,avatar.money-=dressprice);
                    check=false;
                    break;

                case 2:

                    System.out.println("You bought some Show");
                    avatar.setMoney(avatar.money-=shoeprice);
                    DataBase.updateInfo("avatars","money",username,avatar.money-=shoeprice);
                    check=false;
                    break;


                case 3:

                    System.out.println("You bought some Hat");
                    avatar.setMoney(avatar.money-=hatprice);
                    DataBase.updateInfo("avatars","money",username,avatar.money-=hatprice);
                    check=false;
                    break;

                case 4:

                    Menu.showUserMenu();
                    check=false;
                    break;
                default:

                    System.out.println("Wrong choice!!!");
            }
        }
    }

    @Override
    public void buy() {

    }

    @Override
    public void sell() {

    }


}
