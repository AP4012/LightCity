package org.example;

import org.example.models.User;

import java.util.Scanner;

public class Menu {
    private static Game game = new Game();
    private static Scanner scanner = new Scanner(System.in);

    public static void showMenu() {
        while (true) {
            mainMenu();
            String next = scanner.next();
            if (next.equals("1")) {
                game.continueGame(loginMenu());
            } else if (next.equals("2")) {
                game.startGame(loginMenu());
            } else if (next.equals("3")) {
                joinServer();
            } else if (next.equals("4"))
                System.exit(0);
        }
    }

    public static void mainMenu() {
//        show menu : sout ()
        System.out.println("****************************");
        System.out.println("***      1-Continue      ***");
        System.out.println("***   2-Start New Game   ***");
        System.out.println("***    3-Join Server     ***");
        System.out.println("***       4-Exit         ***");
        System.out.println("****************************");

    }

    public static void userMenu()//print option for user
    {
        System.out.println("****************************");
        System.out.println("***      1-Go to         ***");
        System.out.println("***  2-Process Location  ***");
        System.out.println("***     3-Dashboard      ***");
        System.out.println("***       4-Life         ***");
        System.out.println("***       5-Exit         ***");
        System.out.println("****************************");
    }

    public static void showUserMenu(User user)//
    {
        userMenu();
        String next = scanner.next();
        switch (next) {
            case "1": {
                System.out.println("**   Enter location (1 or 2) **");
                System.out.println("**      a. Location ID       **");
                System.out.println("**     b. Industry Title     **");
                String nextGoTo = scanner.next();
                if (nextGoTo.equals("a")) {
                    System.out.print("Enter Your Location ID : ");
                    String LocationId = scanner.next();
                    //complete this part
                } else if (nextGoTo.equals("b")) {
                    System.out.print("Enter Your Industry Title : ");
                    String IndustryTitle = scanner.next();
                    //complete this part
                }
            }
            case "2": {
                System.out.println("**                          Show Detail (1 or 2)                                **");
                System.out.println("**      a. Show where is character : Property detail {position , title,…}       **");
                System.out.println("**        b. Show options according to Industry and Property ownership          **");
                String nextGoTo = scanner.next();
                if (nextGoTo.equals("a")) {
                    //kia(level of user)
                    //complete this part
                } else if (nextGoTo.equals("b")) {
                    //option of user industry
                    //complete this part
                }
            }
            case "3": {
                System.out.println("a. My Job");
                System.out.println("b. Properties");
                System.out.println("c. Economy");
                String nextGoTo = scanner.next();
                if (nextGoTo.equals("a")) {
                    System.out.println("i. Find Job");
                    String nextGoToOptions = scanner.next();
                    if (nextGoToOptions.equals("i")) {
                        //find job
                    }
                } else if (nextGoTo.equals("b")) {
                    System.out.println("i. Show Properties");
                    System.out.println("ii. Sell");
                    System.out.println("iii. Management");
                    System.out.println("iv. Found Industry");
                    String nextGoToOptions = scanner.next();
                    if (nextGoToOptions.equals("i")) {
                        //show prprty
                    } else if (nextGoToOptions.equals("ii")) {
                        //sell
                    } else if (nextGoToOptions.equals("iii")) {
                        //management
                    } else if (nextGoToOptions.equals("iv")) {
                        //found indstry
                    }
                } else if (nextGoTo.equals("c")) {
                    System.out.println("i. Show Incomes");
                    System.out.println("ii. Show Job Detail");
                    System.out.println("iii. How Can Grow Up");
                    String nextGoToOptions = scanner.next();
                    if (nextGoToOptions.equals("i")) {
                        //show incomes
                    } else if (nextGoToOptions.equals("ii")) {
                        //show job detail
                    } else if (nextGoToOptions.equals("iii")) {
                        //H C Grow Up
                    }
                }
            }
            case ("4"): {
                System.out.println("a. Life Detail");
                System.out.println("b. Sleep Function");
                System.out.println("c. Eat Function");
                System.out.println("d. Show (Food , Water , Sleep) Percent");
            }
            case ("5"): {
                System.out.println("a. Are You Sure?");
                String nextGoTo = scanner.next();
                if (nextGoTo.equals("a")) {
                    System.exit(0);
                }
            }
        }
    }

    public static User loginMenu() {
        boolean b = true;
        while (b) {
            Scanner input = new Scanner(System.in);
            System.out.print("** Enter your username : ");
            String username = input.nextLine();
            System.out.print("** Enter your password: ");
            String password = input.nextLine();
            User user = new User(username, password);
            if (Database.loginGame(user) != null) {
                return user;
            } else {
                System.out.println("1. logIn");
                System.out.println("2. signUp");
                String temp = input.nextLine();
                switch (temp) {
                    case "1" -> loginMenu();
                    case "2" -> registerMenu();
                    case "3" -> b = false;
                }
            }
        }
        return null;
    }

    private static void joinServer() {
        System.out.print("Enter Server Ip Address :");
        String ip = scanner.next();
        System.out.print("Enter Server Port :");
        int port = scanner.nextInt();
        game.joinServer(ip, port);
    }

    public static User registerMenu() {
        boolean b = true;
        while (b){
            Scanner input = new Scanner(System.in);
            System.out.print("** Enter your username : ");
            String username = input.nextLine();
            System.out.print("** Enter your password: ");
            String password = input.nextLine();
            User user = new User(username, password);
            if (Database.loginGame(user) != null) {
                return user;
            } else {
                System.out.println("1. logIn");
                System.out.println("2. back");
            }
            String next = input.nextLine();
            switch (next) {
                case "1" -> loginMenu();
                case "2" -> b = false;
            }
        }
            return null;
    }

    public static void main(String[] args) {
        showMenu();
    }
}
