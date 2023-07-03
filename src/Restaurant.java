package org.example;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Restaurant  extends Property implements Cityinterface{

    public String food;
    public String drink;
    public float foodprice=0.2f;
    public float drinkprice=0.1f;
    public Avatar restaurantstaffs;


    public float salary;
    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Restaurant(int id, String title, String ownerID, String description, float value, float coordinate, boolean status,float salary) {
        super(id, title, ownerID, description, value, coordinate, status);
        this.salary=salary;
        this.id++;
    }

    public Restaurant(){

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
            System.out.println("1. Pizza:");
            System.out.println("2. Spaghetti:");
            System.out.println("3. Hamburger:");
            System.out.println("4. Pasta:");
            System.out.println("5. Fried Potatoes:");
            System.out.println("6. Cheeseburger:");
            System.out.println("7. Barbeque:");
            System.out.println("8. Soda pop:");
            System.out.println("9. Beer");
            System.out.println("10. Wine:");
            System.out.println("11. Whisky:");
            System.out.println("12. Vodka:");
            System.out.println("13. Back to User Menu");
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            switch (n) {

                case 1:

                    DataBase.updateInfo("avatars", "food", username, avatar.Food += 50);
                    avatar.setFood(avatar.Food += 50);
                    System.out.println("You eat an Pizza");
                    avatar.setMoney(avatar.money-=foodprice);
                    DataBase.updateInfo("avatars","money",username,avatar.money-=foodprice);
                    check=false;
                    break;

                case 2:
                    DataBase.updateInfo("avatars", "food", username, avatar.Food += 50);
                    avatar.setFood(avatar.Food += 50);
                    System.out.println("You eat an Spaghetti");
                    avatar.setMoney(avatar.money-=foodprice);
                    DataBase.updateInfo("avatars","money",username,avatar.money-=foodprice);
                    check=false;
                    break;
                case 3:
                    DataBase.updateInfo("avatars", "food", username, avatar.Food += 50);
                    avatar.setFood(avatar.Food += 50);
                    System.out.println("You eat an Hamburger");
                    avatar.setMoney(avatar.money-=foodprice);
                    DataBase.updateInfo("avatars","money",username,avatar.money-=foodprice);
                    check=false;
                    break;
                case 4:
                    DataBase.updateInfo("avatars", "food", username, avatar.Food += 50);
                    avatar.setFood(avatar.Food += 50);
                    System.out.println("You eat an Pasta");
                    avatar.setMoney(avatar.money-=foodprice);
                    DataBase.updateInfo("avatars","money",username,avatar.money-=foodprice);
                    check=false;
                    break;
                case 5:
                    DataBase.updateInfo("avatars", "food", username, avatar.Food += 50);
                    avatar.setFood(avatar.Food += 50);
                    System.out.println("You eat an Fried Potatoes");
                    avatar.setMoney(avatar.money-=foodprice);
                    DataBase.updateInfo("avatars","money",username,avatar.money-=foodprice);
                    check=false;
                    break;
                case 6:
                    DataBase.updateInfo("avatars", "food", username, avatar.Food += 50);
                    avatar.setFood(avatar.Food += 50);
                    System.out.println("You eat an Cheeseburger");
                    avatar.setMoney(avatar.money-=foodprice);
                    DataBase.updateInfo("avatars","money",username,avatar.money-=foodprice);
                    check=false;
                    break;
                case 7:
                    DataBase.updateInfo("avatars", "food", username, avatar.Food += 50);
                    avatar.setFood(avatar.Food += 50);
                    System.out.println("You eat an Barbeque");
                    avatar.setMoney(avatar.money-=foodprice);
                    DataBase.updateInfo("avatars","money",username,avatar.money-=foodprice);
                    check=false;
                    break;
                case 8 :

                    DataBase.updateInfo("avatars", "water", username, avatar.Water += 50);
                    avatar.setWater(avatar.Water += 50);
                    System.out.println("You drink an Soda pop");
                    avatar.setMoney(avatar.money-=drinkprice);
                    DataBase.updateInfo("avatars","money",username,avatar.money-=drinkprice);
                    check=false;
                    break;
                case 9:
                    DataBase.updateInfo("avatars", "water", username, avatar.Water += 50);
                    avatar.setWater(avatar.Water += 50);
                    System.out.println("You drink an Beer");
                    avatar.setMoney(avatar.money-=drinkprice);
                    DataBase.updateInfo("avatars","money",username,avatar.money-=drinkprice);
                    check=false;
                    break;
                case 10:
                    DataBase.updateInfo("avatars", "water", username, avatar.Water += 50);
                    avatar.setWater(avatar.Water += 50);
                    System.out.println("You drink an Whine");
                    avatar.setMoney(avatar.money-=drinkprice);
                    DataBase.updateInfo("avatars","money",username,avatar.money-=drinkprice);
                    check=false;
                    break;
                case 11:
                    DataBase.updateInfo("avatars", "water", username, avatar.Water += 50);
                    avatar.setWater(avatar.Water += 50);
                    System.out.println("You drink an Whisky");
                    avatar.setMoney(avatar.money-=drinkprice);
                    DataBase.updateInfo("avatars","money",username,avatar.money-=drinkprice);
                    check=false;
                    break;
                case 12:
                    DataBase.updateInfo("avatars", "water", username, avatar.Water += 50);
                    avatar.setWater(avatar.Water += 50);
                    System.out.println("You drink an Vodka");
                    avatar.setMoney(avatar.money-=drinkprice);
                    DataBase.updateInfo("avatars","money",username,avatar.money-=drinkprice);
                    check=false;
                    break;
                case 13:
                    Menu.showUserMenu();
                    check=false;
                    break;
                default:
                    System.out.println("Try again");
            }
        }
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public float getFoodprice() {
        return foodprice;
    }

    public void setFoodprice(float foodprice) {
        this.foodprice = foodprice;
    }

    public float getDrinkprice() {
        return drinkprice;
    }

    public void setDrinkprice(float drinkprice) {
        this.drinkprice = drinkprice;
    }

    public Avatar getRestaurantstaffs() {
        return restaurantstaffs;
    }

    public void setRestaurantstaffs(Avatar restaurantstaffs) {
        this.restaurantstaffs = restaurantstaffs;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                ", restaurantstaffs=" + restaurantstaffs +
                ", title='" + title + '\'' +
                ", owner-username=" + ownerusername +
                ", description='" + description + '\'' +
                ", value=" + value +
                ", coordinate=" + coordinate +
                ", status=" + status +
                '}';
    }
}
