package org.example;

import java.util.*;
public class Menu {
    public static String username;
    public static String password;
    public static void showMenu() throws Exception {


        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("==== Main Menu ====");
            System.out.println("1. Continue");
            System.out.println("2. Start New Game");
            System.out.println("3. Join Server");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    Scanner scanner2=new Scanner(System.in);
                    System.out.print("Enter your username: ");
                    username = scanner2.nextLine();
                    System.out.print("Enter your password: ");
                    password = scanner2.nextLine();
                    boolean flag = false;
                    for (int i =0;i<Game.city.getAvatars().size();i++){

                        if (Game.city.getAvatars().get(i).getUsername().equals(username) && EncryptionUtils.decrypt(Game.city.getAvatars().get(i).getPassword()).equals(password)) {

                            flag = true;
                            break;

                        }

                    }
                    if (flag){
                        System.out.println("You successfully Sign In...");
                        showUserMenu();
                    }
                    else {
                        System.out.println("Your password or username is Wrong");
                        System.out.println();
                        showMenu();

                    }
                    // TODO: Implement continue logic
                    break;
                case 2:
                    Scanner scanner1=new Scanner(System.in);
                    System.out.println("Enter your username: ");
                    String username_new = scanner1.nextLine();
                    for (Avatar i:Game.city.getAvatars()){
                    if (Objects.equals(i.getUsername(), username_new)){
                        System.out.println("You SignUp in past...\nPlease choose continue!!!\nor someone used this username in past,\nso Choose New Game again and take another username...");
                        showMenu();
                    }
                }

                    System.out.println("Enter your password: ");
                    String password_new = scanner1.nextLine();
                    System.out.println("Enter your title: ");
                    String title_new = scanner1.nextLine();
                    System.out.println("Enter your gender: ");
                    String gender_new = scanner1.nextLine();
                    Avatar avatar=new Avatar(username_new,EncryptionUtils.encrypt(password_new),title_new,gender_new,10,100,100,"",0,100,0,0,100);
                    Game.city.getAvatars().add(avatar);
                    DataBase.saveAvatars(Game.city,avatar);
                    System.out.println("You successfully SignUP...");

                    // TODO: Implement start new game logic
                    break;
                case 3:
                    System.out.print("Enter server IP address: ");
                    String ipAddress = scanner.next();
                    System.out.print("Enter server port: ");
                    int port = scanner.nextInt();
                    System.out.println("NOOOOOOOOOO!!!");
                    // TODO: Implement join server logic
                    break;
                case 4:

                        System.exit(0);

                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        } while (choice != 4);
    }
    public static void showUserMenu() {


        DataBase dataBase=new DataBase();
        dataBase.selectAll(Game.city);

        Avatar avatar10 = null;
        for (Avatar i : Game.city.getAvatars()) {
            if (Objects.equals(i.getUsername(), username)) {
                avatar10 = i;
            }
        }
        assert avatar10 != null;
        if (avatar10.properties.size()==0){
            Avatar.AddtoProperty(username);
        }

//        Avatar avatar0 = null;
//        for (Avatar i : Game.city.getAvatars()) {
//            if (Objects.equals(i.getUsername(), username)) {
//                avatar0 = i;
//                break;
//            }
//        }
//        assert avatar0 != null;
//        for (Property i :Game.city.getProperties()){
//            if (Objects.equals(i.getOwnerusername(), username)){
//                System.out.println(i);
//            }
//        }
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("==== User Menu ====");
            System.out.println("1.  Go to");
            System.out.println("2.  Process Location");
            System.out.println("3.  Dashboard");
            System.out.println("4.  Life");
            System.out.println("5.  Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            int choice1;
            switch (choice) {
                case 1:



                    Avatar.GoTo(username);


//                    System.out.println("====  Enter your choice ====");
//                    System.out.println("1. Enter location coordinate:");
//                    System.out.println("2. Enter id:");
//                    System.out.println("3. Enter industry title:");
//                    System.out.println("4. Back to User Menu:");
//                    System.out.println("5.  Exit");
//                    choice1=scanner.nextInt();
//                    while (choice1 !=5) {
//
//                        switch (choice1) {
//                            case 1:
//                                float coordinate = scanner.nextFloat();
//                                for (Property i:Game.city.getProperties()){
//                                    if (i.getCoordinate()==coordinate){
//
//                                        //place function
//
//                                    }
//                                }
//                                break;
//                            case 2:
//                                int id = scanner.nextInt();
//                                for (Property i:Game.city.getProperties()){
//                                    if (i.getId()==id){
//
//                                        //place function
//
//                                    }
//                                }
//                                break;
//                            case 3:
//                                String title = scanner.nextLine();
//                                for (Property i:Game.city.getProperties()) {
//                                    if (i.getTitle() == title) {
//
//                                        //place menu
//
//                                    }
//                                }
//                                break;
//                            case 4:
//
//                                showUserMenu();
//                                break;
//
//                            case 5:
//
//                                System.exit(0);
//                                break;
//
//                            default:
//                                System.out.println("Invalid choice, please try again.");
//                        }
//                    }

                    // TODO: Implement Go to logic
                    break;
                case 2:

                    System.out.println("1. Show where is character : ");
                    System.out.println("2. Show options according to Industry and Property ownership : ");
                    int no=scanner.nextInt();
                    if (no==1){

                        for (Avatar i:Game.city.getAvatars()){
                            if (Objects.equals(i.getUsername(), username)){
                                System.out.println(i.getTitle()+":");
                                System.out.println("Position: "+i.getCoordinate());
                                for (Property j:Game.city.getProperties()){
                                    if (j.getCoordinate()==i.getCoordinate()){
                                        System.out.println("Position title:"+j.getTitle());
                                    }
                                }
                            }

                        }

                    } else if (no==2) {


                        Avatar.ShowProperty(username);
//                        for (Avatar i:Game.city.getAvatars()){
//                            if (Objects.equals(i.getUsername(), username)){
//                                System.out.println(i.properties);
//                                System.out.println();
//                            }
//                        }
                    }
                    else {

                        System.out.println("Wrong Number!!!\n Try Again...");
                        showUserMenu();

                    }
//                   a. (Show where is character : Property detail {position , title,…})
//                   b. (Show options according to Industry and Property ownership)
                    // TODO: Implement process logic
                    break;
                case 3:

                    boolean check3=true;

                    while (check3){

                        System.out.println("====  Enter your choice ====");
                        System.out.println("1. Find job:");
                        System.out.println("2. Properties:");
                        System.out.println("3. Economy :");
                        System.out.println("4. Back to main menu:");
                        System.out.println("5.  Exit");
                        int choice2=scanner.nextInt();
                        switch (choice2){
                            case 1:

                                System.out.println(" Which job are you looking for? ");
                                System.out.println(" 1. Bank");
                                System.out.println(" 2. Boutique");
                                System.out.println(" 3. Clinic");
                                System.out.println(" 4. Factory");
                                System.out.println(" 5. Restaurant");
                                System.out.println(" 6. Supermarket");
                                System.out.println(" 7. Back to User Menu");
                                Scanner inpObj = new Scanner(System.in);
                                int input = inpObj.nextInt();
                                boolean check4=true;
                                while (check4){

                                switch (input) {

                                    case 1:

                                        Avatar avatar1 = null;
                                        for (Avatar i : Game.city.getAvatars()) {
                                            if (Objects.equals(i.getUsername(), username)) {
                                                avatar1 = i;
                                            }
                                        }

                                        Bank bank = null;
                                        for (Bank j : Game.city.getBanks()) {
                                            if (Objects.equals(j.getId(), 1)) {
                                                bank = j;
                                            }
                                        }

                                        assert avatar1 != null;
                                        assert bank != null;
                                        avatar1.setJob(bank.getTitle());
                                        avatar1.setIncome(bank.getSalary());
                                        avatar1.setIndustryid(bank.getId());
                                        DataBase.updateInfo("avatars", "job", avatar1.getUsername(), bank.getTitle());
                                        DataBase.updateInfo("avatars","income" , avatar1.getUsername(), bank.getSalary());
                                        DataBase.updateInfo("avatars", "industryid", avatar1.getUsername(), bank.getId());
                                        System.out.println("You successfully hired!");
                                        Menu.showUserMenu();
//                                        avatar1.getJob()avatar1.getIncome()avatar1.getIndustryid()
                                        check4=false;
                                        break;

                                    case 2:

                                        Avatar avatar2 = null;
                                        for (Avatar i : Game.city.getAvatars()) {
                                            if (Objects.equals(i.getUsername(), username)) {
                                                avatar2 = i;
                                            }
                                        }
                                        Boutique boutique = null;
                                        for (Boutique j : Game.city.getBoutiques()) {
                                            if (Objects.equals(j.getId(), 2)) {
                                                boutique = j;
                                            }
                                        }
                                        assert avatar2 != null;
                                        assert boutique != null;
                                        avatar2.setJob(boutique.getTitle());
                                        avatar2.setIncome(boutique.getSalary());
                                        avatar2.setIndustryid(boutique.getId());
                                        DataBase.updateInfo("avatars", "job", avatar2.getUsername(), boutique.getTitle());
                                        DataBase.updateInfo("avatars","income" , avatar2.getUsername(), boutique.getSalary());
                                        DataBase.updateInfo("avatars", "industryid", avatar2.getUsername(), boutique.getId());
                                        System.out.println("You successfully hired!");
                                        Menu.showUserMenu();
                                        check4=false;
                                        break;

                                    case 3:

                                        Avatar avatar3 = null;
                                        for (Avatar i : Game.city.getAvatars()) {
                                            if (Objects.equals(i.getUsername(), username)) {
                                                avatar3 = i;
                                            }
                                        }
                                        Clinic clinic = null;
                                        for (Clinic j : Game.city.getClinics()) {
                                            if (Objects.equals(j.getId(), 3)) {
                                                clinic = j;
                                            }
                                        }

                                        assert avatar3 != null;
                                        assert clinic != null;
                                        avatar3.setJob(clinic.getTitle());
                                        avatar3.setIncome(clinic.getSalary());
                                        avatar3.setIndustryid(clinic.getId());
                                        DataBase.updateInfo("avatars", "job", avatar3.getUsername(), clinic.getTitle());
                                        DataBase.updateInfo("avatars", "income" , avatar3.getUsername(), clinic.getSalary());
                                        DataBase.updateInfo("avatars", "industryid", avatar3.getUsername(), clinic.getId());
                                        System.out.println();
                                        System.out.println("1. As Doctor");
                                        System.out.println("2. As Nurse");
                                        Scanner scanner7=new Scanner(System.in);
                                        int x=scanner7.nextInt();

                                        if (x==1){
                                            if (!DataBase.doctor){
                                                clinic.setDoctors(avatar3);
                                                DataBase.updateInfo("clinic","doctorsid",3,avatar3.getUsername());
                                                System.out.println("Welcome Doctor");
                                            }
                                            else {
                                                System.out.println("This clinic has already a Doctor!");
                                                System.out.println("You successfully hired as a staff!");
                                            }
                                        } else if (x==2) {
                                            if (!DataBase.nurse){
                                                clinic.setNurses(avatar3);
                                                DataBase.updateInfo("clinic","nursesid",3,avatar3.getUsername());
                                                System.out.println("Welcome Nurse");
                                            }
                                            else {
                                                System.out.println("This clinic has already a Nurse!");
                                                System.out.println("You successfully hired as a staff!");
                                            }
                                        }
                                        Menu.showUserMenu();
                                        check4=false;
                                        break;

                                    case 4:

                                        Avatar avatar4 = null;
                                        for (Avatar i : Game.city.getAvatars()) {
                                            if (Objects.equals(i.getUsername(), username)) {
                                                avatar4 = i;
                                            }
                                        }
                                        Factory factory = null;
                                        for (Factory j : Game.city.getFactories()) {
                                            if (Objects.equals(j.getId(), 4)) {
                                                factory = j;
                                            }
                                        }
                                        assert avatar4 != null;
                                        assert factory != null;
                                        avatar4.setJob(factory.getTitle());
                                        avatar4.setIncome(factory.getSalary());
                                        avatar4.setIndustryid(factory.getId());
                                        DataBase.updateInfo("avatars", "job", avatar4.getUsername(), factory.getTitle());
                                        DataBase.updateInfo("avatars", "income" , avatar4.getUsername(), factory.getSalary());
                                        DataBase.updateInfo("avatars", "industryid", avatar4.getUsername(), factory.getId());
                                        System.out.println("You successfully hired!");
                                        Menu.showUserMenu();
                                        check4=false;
                                        break;

                                    case 5:

                                        Avatar avatar5 = null;
                                        for (Avatar i : Game.city.getAvatars()) {
                                            if (Objects.equals(i.getUsername(), username)) {
                                                avatar5 = i;
                                            }
                                        }
                                        Restaurant restaurant = null;
                                        for (Restaurant j : Game.city.getRestaurants()) {
                                            if (Objects.equals(j.getId(), 5)) {
                                                restaurant = j;
                                            }
                                        }
                                        assert avatar5 != null;
                                        assert restaurant != null;
                                        avatar5.setJob(restaurant.getTitle());
                                        avatar5.setIncome(restaurant.getSalary());
                                        avatar5.setIndustryid(restaurant.getId());
                                        DataBase.updateInfo("avatars", "job", avatar5.getUsername(), restaurant.getTitle());
                                        DataBase.updateInfo("avatars", "income" , avatar5.getUsername(), restaurant.getSalary());
                                        DataBase.updateInfo("avatars", "industryid", avatar5.getUsername(), restaurant.getId());
                                        System.out.println("You successfully hired!");
                                        Menu.showUserMenu();
                                        check4=false;
                                        break;

                                    case 6:

                                        Avatar avatar6 = null;
                                        for (Avatar i : Game.city.getAvatars()) {
                                            if (Objects.equals(i.getUsername(), username)) {
                                                avatar6 = i;
                                            }
                                        }
                                        Supermarket supermarket = null;
                                        for (Supermarket j : Game.city.getSupermarkets()) {
                                            if (Objects.equals(j.getId(), 6)) {
                                                supermarket = j;
                                            }
                                        }

                                        assert avatar6 != null;
                                        assert supermarket != null;
                                        avatar6.setJob(supermarket.getTitle());
                                        avatar6.setIncome(supermarket.getSalary());
                                        avatar6.setIndustryid(supermarket.getId());
                                        DataBase.updateInfo("avatars", "job", avatar6.getUsername(), supermarket.getTitle());
                                        DataBase.updateInfo("avatars", "income" , avatar6.getUsername(), supermarket.getSalary());
                                        DataBase.updateInfo("avatars","industryid", avatar6.getUsername(), supermarket.getId());
                                        System.out.println("You successfully hired!");
                                        Menu.showUserMenu();
                                        check4=false;
                                        break;

                                    case 7:

                                        Menu.showUserMenu();
                                        check4=false;
                                        break;

                                    default:

                                        System.out.println("try again");

                                    }
                                }


                            case 2:

                                System.out.println("1. Show My Properties:");
                                System.out.println("2. Sell:");
                                System.out.println("3. Management:");
                                System.out.println("4. Found and Buy:");
                                System.out.println("5. Back to User Menu:");
                                Scanner scanner4=new Scanner(System.in);
                                int in=scanner4.nextInt();
                                if (in==1){

                                    Avatar.ShowProperty(username);
                                    Menu.showUserMenu();

//                                Avatar avatar=null;
//                                for (Avatar i:Game.city.getAvatars()){
//                                    if (Objects.equals(i.getUsername(), username)){
//                                        avatar=i;
//                                        break;
//                                    }
//                                }
//                                assert avatar != null;
//                                Avatar.showProperty(avatar);
                                } else if (in==2) {
                                    
                                    Avatar.sell(username);
                                    Menu.showUserMenu();
                                } else if (in==3) {


                                    Avatar.Management(username);
                                    Menu.showUserMenu();

//
//                                    Avatar avatar=null;
//                                    for (Avatar i:Game.city.getAvatars()){
//                                        if (Objects.equals(i.getUsername(), username)){
//                                            avatar=i;
//                                            break;
//                                        }
//                                    }
//                                    assert avatar != null;
//                                    for (Property i:avatar.getProperties()){
//                                        System.out.println(i);
//                                    }
////                                    Scanner s=new Scanner(System.in);
////                                    int num=s.nextInt();
////                                    for (Property i:avatar.getProperties()){
////                                        if ()
////                                    }
//                                    boolean check7=true;
//                                    while (check7){
//                                        System.out.println("What you want to do?");
//                                        System.out.println("1. Change income:");
//                                        System.out.println("2. Change Employee:");
//                                        System.out.println("4. Back to main menu:");
//                                        Scanner s=new Scanner(System.in);
//                                        int num=s.nextInt();
//                                    }
//

                                } else if (in==4) {

                                    Avatar.buy(username);
                                    Menu.showUserMenu();
                                } else if (in==5) {
                                    Menu.showUserMenu();
                                }else {
                                    System.out.println("Wrong choice");
                                    Menu.showUserMenu();
                                }

                            case 3:

                                dataBase.selectAll(Game.city);
                                Avatar.ShowIncomeandJobDetail(username);

                            case 4:

                                Menu.showUserMenu();
                                break;

                            default:

                                System.out.println("try again");
                        }

                    }
//                    a. My job
//                    i. Find job
//                    b. Properties
//                    i. Show Properties
//                    ii. Sell
//                    iii. Management
//                    iv. Found industry
//                    c. Economy
//                    i. Show incomes
//                    ii. Show job detail
//                    iii. How can grow up ?
                    // TODO: Implement dashboard logic
                    break;
                case 4:

                    Avatar.Life(username);
//                    a. Life Detail
//                    i. Show sleep , water , food percentage
//                    b. Sleep function
//                    c. Eat function
//                    d. (Show food , water , sleep percent)
                    // TODO: Implement life logic
                    break;

                case 5:
                    System.out.println("Are you sure you want to exit? (Y/N)");
                    String confirm = scanner.next();
                    if (confirm.equalsIgnoreCase("Y")) {
                        System.exit(0);
                        break;
                    }
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        } while (choice != 5);
    }
}
