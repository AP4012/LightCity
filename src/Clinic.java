package org.example;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Clinic extends Property implements Cityinterface{

    public static Avatar Doctors;
    public static Avatar Nurses;
    public ArrayList<Avatar> patients;

    public static float fee=1;


    public float salary;
    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
    public Clinic(int id, String title, String ownerID, String description, float value, float coordinate, boolean status, Avatar doctors, Avatar nurses,float salary) {
        super(id, title, ownerID, description, value, coordinate, status);
        this.salary=salary;
        Doctors = doctors;
        Nurses = nurses;
        ArrayList<Avatar> patients=new ArrayList<>();
        this.id++;

    }

    public Clinic(){

    }


    public Avatar getDoctors() {
        return Doctors;
    }

    public void setDoctors(Avatar doctors) {
        Doctors = doctors;
    }

    public Avatar getNurses() {
        return Nurses;
    }

    public void setNurses(Avatar nurses) {
        Nurses = nurses;
    }


    public ArrayList<Avatar> getPatients() {
        return patients;
    }

    public void setPatients(ArrayList<Avatar> patients) {
        this.patients = patients;
    }

    @Override
    public String toString() {
        return "Clinic{" +
                ", doctors="+ getDoctors()+
                ", nurses="+ getNurses()+
                "patients=" + patients +
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
        avatar.setCoordinate(Game.city.getClinics().get(1).getCoordinate());
        avatar.setHealth(avatar.health-=5);
        avatar.setFood(avatar.Food-=5);
        avatar.setWater(avatar.Water-=5);
        DataBase.updateInfo("avatars","health",username,avatar.health-=5);
        DataBase.updateInfo("avatars","food",username,avatar.Food-=5);
        DataBase.updateInfo("avatars","water",username,avatar.Water-=5);
        DataBase.updateInfo("avatars","coordinate",username,Game.city.getClinics().get(1).getCoordinate());
        boolean check=true;


        while (check) {
            System.out.println("Which one do you want to do?");
            System.out.println("1. Have visit With Doctor:");
            System.out.println("2. Take some Medicine:");
            System.out.println("3. Back to User Menu");
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            switch (n) {

                case 1:
                    System.out.println("You have visit wih doctor");
                    avatar.setMoney(avatar.money-=fee);
                    DataBase.updateInfo("avatars","money",username,avatar.money-=fee);
                    check=false;
                    break;

                case 2:

                    System.out.println("You bought some medicine");
                    avatar.setMoney(avatar.money-=fee);
                    DataBase.updateInfo("avatars","money",username,avatar.money-=fee);
                    check=false;
                    break;
                case 3:

                    Menu.showUserMenu();
                    check=false;
                    break;
                default:
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
