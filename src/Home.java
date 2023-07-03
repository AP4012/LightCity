package org.example;

import java.util.Objects;

public class Home extends Property implements Cityinterface{

    public String kind;
    public int roomNo;
    public int age;


    public Home(int id, String title, String ownerID, String description, float value, float coordinate, boolean status, String kind, int roomNo, int age) {
        super(id, title, ownerID, description, value, coordinate, status);
        this.kind = kind;
        this.roomNo = roomNo;
        this.age = age;
        this.id++;
    }

    public Home(){

    }
    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Home{" +
                "kind='" + kind + '\'' +
                ", roomNo=" + roomNo +
                ", age=" + age +
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
        avatar.setCoordinate(Game.city.getHomes().get(1).getCoordinate());
        avatar.setHealth(avatar.health += 20);
//        avatar.setFood(avatar.Food -= 5);
//        avatar.setWater(avatar.Water -= 5);
        DataBase.updateInfo("avatars", "health", username, avatar.health += 20);
//        DataBase.updateInfo("avatars", "food", username, avatar.Food -= 5);
//        DataBase.updateInfo("avatars", "water", username, avatar.Water -= 5);
        DataBase.updateInfo("avatars", "coordinate", username, Game.city.getHomes().get(1).getCoordinate());
        avatar.setSleep(100);
        DataBase.updateInfo("avatars", "sleep", username, 100);
        System.out.println("You sleep very well...");

    }


}
