package org.example;

import java.util.Objects;
import java.util.Scanner;

public class Bank  extends Property implements Cityinterface{

    public int payerID;
    public int recieverID;
    public int transactionID;
    public float amountofMoney;
    public Avatar Bankstaffs;


    public float salary;
    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Bank(int id, String title, String ownerID, String description, float value, float coordinate, boolean status,float salary) {
        super(id, title, ownerID, description, value, coordinate, status);
        this.amountofMoney = amountofMoney;
        this.salary=salary;
        this.id++;
    }
    public Bank(){

    }


    public int getPayerID() {
        return payerID;
    }

    public void setPayerID(int payerID) {
        this.payerID = payerID;
    }

    public int getRecieverID() {
        return recieverID;
    }

    public void setRecieverID(int recieverID) {
        this.recieverID = recieverID;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public float getAmountofMoney() {
        return amountofMoney;
    }

    public void setAmountofMoney(int amountofMoney) {
        this.amountofMoney = amountofMoney;
    }

    public Avatar getBankstaffs() {
        return Bankstaffs;
    }

    public void setBankstaffs(Avatar bankstaffs) {
        Bankstaffs = bankstaffs;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "Bankstaffs=" + Bankstaffs +
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
        avatar.setCoordinate(Game.city.getBanks().get(1).getCoordinate());
        avatar.setHealth(avatar.health-=5);
        avatar.setFood(avatar.Food-=5);
        avatar.setWater(avatar.Water-=5);
        DataBase.updateInfo("avatars","health",username,avatar.health-=5);
        DataBase.updateInfo("avatars","food",username,avatar.Food-=5);
        DataBase.updateInfo("avatars","water",username,avatar.Water-=5);
        DataBase.updateInfo("avatars","coordinate",username,Game.city.getBanks().get(1).getCoordinate());
        boolean check=true;

        while (check){
            System.out.println("Which one do you want to do?");
            System.out.println("1. Give money to another");
            System.out.println("2. Take money from another");
            System.out.println("3. Buy");
            System.out.println("4. Back to User Menu");
            Scanner scanner=new Scanner(System.in);
            int n=scanner.nextInt();
            switch (n){
                case 1:

                    System.out.println("Username of that Person:");
                    String name=scanner.nextLine();
                    System.out.println("A mount of Money that you want to give:");
                    float some=scanner.nextFloat();
                    for (Avatar a:Game.city.getAvatars()){
                        if (Objects.equals(a.getUsername(), name)){

                            Avatar avatar1 = null;
                            for (Avatar i : Game.city.getAvatars()) {
                                if (Objects.equals(i.getUsername(), name)) {
                                    avatar1 = i;
                                }
                            }
                            assert avatar1 != null;
                            avatar.setMoney(avatar.money-=some);
                            avatar1.setMoney(avatar1.money+=some);
                            DataBase.updateInfo("avatars","money",username,avatar.money-=some);
                            DataBase.updateInfo("avatars","money",name,avatar1.money+=some);

                        }
                    }
                    check=false;
                    break;

                case 2:


                    System.out.println("Username of that Person:");
                    String name1=scanner.nextLine();
                    System.out.println("A mount of Money that you want to take:");
                    float some1=scanner.nextFloat();
                    for (Avatar a:Game.city.getAvatars()){
                        if (Objects.equals(a.getUsername(), name1)){

                            Avatar avatar1 = null;
                            for (Avatar i : Game.city.getAvatars()) {
                                if (Objects.equals(i.getUsername(), name1)) {
                                    avatar1 = i;
                                }
                            }
                            assert avatar1 != null;
                            avatar.setMoney(avatar.money+=some1);
                            avatar1.setMoney(avatar1.money-=some1);
                            DataBase.updateInfo("avatars","money",username,avatar.money+=some1);
                            DataBase.updateInfo("avatars","money",name1,avatar1.money-=some1);

                        }
                    }
                    check=false;
                    break;


                case 3:


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
