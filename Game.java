package org.example;

import org.example.interfaces.GameInterface;
import org.example.models.Character;
import org.example.models.City;
import org.example.models.User;

import java.util.ArrayList;
import java.util.Scanner;

public class Game implements GameInterface {

    //    Check Data from Database or file to see There is city or not
    private City city;
    @Override
    public void continueGame(User user) {

        Scanner sc = new Scanner(System.in);

        String username;
        String pass;

        System.out.print("\nEnter your username: ");
        username = sc.nextLine();

        System.out.print("Enter your password: ");
        pass = sc.nextLine();
    }

    /** Create new city and Generate new Character
     * @param user : User information contain username, password
     * */
    @Override
    public void startGame(User user) {
        generateNewCity();
        city.joinCharacter(user);

        Scanner sc = new Scanner(System.in);

        String username;
        String pass;

        System.out.print("\nEnter Username: ");
        username = sc.nextLine();

        System.out.print("Enter Password: ");
        pass = sc.nextLine();
    }

    /**
     * @param ip Server ip address / example : 127.0.0.1
     * @param port Server open port for specific ip address
     * */
    @Override
    public void joinServer(String ip, int port) {

    }

    @Override
    public void generateNewCity() {
        city = new City();
    }

}
