package org.example;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Avatar extends Job{

    protected String username;
    protected String password;

    protected String  title;
    protected Gender gender;
    protected float money;
    protected float Food;
    protected float Water;

    protected float coordinate;
    protected float health;
    protected int sleep;
    protected float drunk;
    public ArrayList<Property> properties=new ArrayList<>();
    public static ArrayList<Avatar> employees=new ArrayList<>();

    Avatar( String username, String password, String title, String gender, float money, float health, int sleep, String job,float coordinate,float Food,float income,int industryid,float Water){
        super(job,income,industryid);
        this.username=username;
        this.password=password;
        this.title=title;
        this.gender= Gender.valueOf(gender);
        this.money=money;
        this.health=health;
        this.sleep=sleep;
        this.coordinate=coordinate;
        this.Food=Food;
        this.Water=Water;
        ArrayList<Property> properties = new ArrayList<>();
    }

    Avatar(String job,float income,int industryid) {
        super(job,income,industryid);
    }


    public static void showProperty(Avatar avatar){

        for (Property p:avatar.getProperties()){
            System.out.println(p);
        }
    }

    public static void GoTo(String username){
            Avatar avatar = null;
            for (Avatar i : Game.city.getAvatars()) {
                if (Objects.equals(i.getUsername(), username)) {
                    avatar = i;
                }
            }
            boolean check=true;
        while (check) {
            Bank bank = new Bank();
            Boutique boutique=new Boutique();
            Clinic clinic=new Clinic();
            Factory factory=new Factory();
            Home home=new Home();
            Land land=new Land();
            Restaurant restaurant=new Restaurant();
            Supermarket supermarket=new Supermarket();
            System.out.println("Which one do you want to do?");
            System.out.println("1. Bank");
            System.out.println("2. Boutique");
            System.out.println("3. Clinic");
            System.out.println("4. Factory");
            System.out.println("5. Home");
            System.out.println("6. Land");
            System.out.println("7. Restaurant");
            System.out.println("8. Supermarket");
            System.out.println("9. Back to User Menu");
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            switch (n) {
                case 1:
                    bank.UseProperty(username);
                    check=false;
                    break;
                case 2:
                    boutique.UseProperty(username);
                    check=false;
                    break;
                case 3:
                    clinic.UseProperty(username);
                    check=false;
                    break;
                case 4:
                    factory.UseProperty(username);
                    check=false;
                    break;
                case 5:
                    home.UseProperty(username);
                    check=false;
                    break;
                case  6:
                    land.UseProperty(username);
                    check=false;
                    break;
                case 7:
                    restaurant.UseProperty(username);
                    check=false;
                    break;
                case 8:
                    supermarket.UseProperty(username);
                    check=false;
                    break;
                case 9 :
                    Menu.showUserMenu();
                    check=false;
                    break;
                default:
                    System.out.println("try again");


            }
        }
    }


    public  static void  Life(String username){
        Avatar avatar = null;
        for (Avatar i : Game.city.getAvatars()) {
            if (Objects.equals(i.getUsername(), username)) {
                avatar = i;
                break;
            }
        }
        boolean check=true;

        while (check){
            System.out.println("==== Life Menu ====");
            System.out.println("1.  Life Detail:");
            System.out.println("2.  Eat something:");
            System.out.println("3.  Sleep:");
            System.out.println("4.  Back to Game Menu:");
            Scanner scanner=new Scanner(System.in);
            int choice=scanner.nextInt();
            switch (choice) {

                case 1:
                    assert avatar != null;
                    System.out.println("Sleep Size:");
                    System.out.println(avatar.getSleep());
                    System.out.println("Food Size:");
                    System.out.println(avatar.getFood());
                    System.out.println("Water Size:");
                    System.out.println(avatar.getWater());
                    System.out.println("Money Size:");
                    System.out.println(avatar.getMoney());
                case 2:
                    Supermarket supermarket=new Supermarket();
                    Restaurant restaurant=new Restaurant();
                    boolean check1=true;
                    while (check1){
                        System.out.println("1. Restaurant");
                        System.out.println("2. Supermarket");
                        Scanner scanner1=new Scanner(System.in);
                        int x= scanner.nextInt();
                        switch (x){

                            case 1:
                                restaurant.UseProperty(username);
                            case 2:
                                supermarket.UseProperty(username);
                            default:
                                System.out.println("try again");

                        }
                    }

                case 3:
                    Home home=new Home();
                    home.UseProperty(username);
                default:
                    System.out.println("Try again");
            }
        }
    }
    public static void AddtoProperty(String username){
        Avatar avatar = null;
        for (Avatar i : Game.city.getAvatars()) {
            if (Objects.equals(i.getUsername(), username)) {
                avatar = i;
                break;
            }
        }
        assert avatar != null;
        for (Property i :Game.city.getProperties()){
            if (Objects.equals(i.getOwnerusername(), username)){
                avatar.properties.add(i);
            }
        }
    }
    public static void Findjob(City city,Avatar avatar){
        Scanner scanner=new Scanner(System.in);
        int choice=scanner.nextInt();
        boolean check=true;

        while (check){
            System.out.println("==== Job Menu ====");
            System.out.println("1.  Bank");
            System.out.println("2.  Boutique");
            System.out.println("3.  Clinic");
            System.out.println("4.  Factory");
            System.out.println("5.  Restaurant");
            System.out.println("6.  Supermarket");
            System.out.println("7.  Back to Game Menu:");
            System.out.println("8.  Exit");
            System.out.println("    Enter your choice: ");

            switch (choice){
                case 1:

                    city.getBanks().get(1).setBankstaffs(avatar);
                    avatar.setJob("Bank");
                    System.out.println("You successfully hired in Bank of city");
                    // output
                    check=false;
                    break;
                case 2:

                    city.getBoutiques().get(1).setBoutiquestaffs(avatar);
                    avatar.setJob("Boutique");
                    System.out.println("You successfully hired in Boutique of city");
                    // output
                    check=false;
                    break;
                case 3:
                    int choice1=scanner.nextInt();
                    boolean check1=true;
                    while (check1){

                        System.out.println("1.  as Doctor");
                        System.out.println("2.  as Nurse");
                        System.out.println("3.  Back to Main Menu");
                        System.out.println("4.  Exit");
                        switch (choice1){
                            case 1:

                                city.getClinics().get(1).setDoctors(avatar);
                                avatar.setJob("Clinic");
                                System.out.println("You successfully hired in as doctor of city");
                                //output
                                check1=false;
                                break;
                            case 2:

                                city.getClinics().get(1).setNurses(avatar);
                                avatar.setJob("Clinic");
                                System.out.println("You successfully hired in nurse of city");
                                //output
                                check1=false;
                                break;
                            case 3:

                                Menu.showUserMenu();
                                check1=false;
                                break;
                            case 4:
                                System.exit(0);
                                break;
                            default:
                                System.out.println("Invalid choice, please try again.");
                        }

                    }

                case 4:

                    city.getFactories().get(1).setFactorystaffs(avatar);
                    avatar.setJob("Factory");
                    System.out.println("You successfully hired in Factory of city");
                    // output
                    check=false;
                    break;
                case 5:

                    city.getRestaurants().get(1).setRestaurantstaffs(avatar);
                    avatar.setJob("Restaurant");
                    System.out.println("You successfully hired in Restaurant of city");
                    // output
                    check=false;
                    break;
                case 6:

                    city.getSupermarkets().get(1).setSupermarketstaffs(avatar);
                    avatar.setJob("Supermarket");
                    System.out.println("You successfully hired in Supermarket of city");
                    // output
                    check=false;
                    break;
                case 7:
                    Menu.showUserMenu();
                    check=false;
                case 8:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }

    }
    public static void ShowIncomeandJobDetail(String username){

        System.out.println(" 1. Show Income:");
        System.out.println(" 2. Show Job Detail:");
        System.out.println(" 3. Back to User Menu");
        Scanner scanner=new Scanner(System.in);
        int no= scanner.nextInt();

        if (no==1) {
            Avatar avatar = null;
            for (Avatar i : Game.city.getAvatars()) {
                if (Objects.equals(i.getUsername(), username)) {
                    avatar = i;
                    break;
                }
            }

            assert avatar != null;
            System.out.println("Income and Salary:");
            System.out.println(avatar.getIncome());
            System.out.println("Profit from start of the Game:");
            System.out.println(avatar.getMoney() - 10);

        } else if (no==2) {

            Avatar avatar = null;
            for (Avatar i : Game.city.getAvatars()) {
                if (Objects.equals(i.getUsername(), username)) {
                    avatar = i;
                    break;
                }
            }

            assert avatar != null;
            System.out.println("The name of work place:");
            System.out.println(avatar.getJob());
            System.out.println("Income:"+avatar.getIncome());
            System.out.println("IndustryID:"+avatar.getIndustryid());

            for (Property i:Game.city.getProperties()){
                if (i.getId()== avatar.getIndustryid()){
                    System.out.println(i);
                }
            }
        }
    }

    public  static void  buy(String username){


        Avatar avatar = null;
        for (Avatar i:Game.city.getAvatars()){
            if (Objects.equals(i.getUsername(), username)){
                avatar=i;
                break;
            }
        }


        assert avatar != null;
        System.out.println("Which one do you want to buy?");
        System.out.println(" 1. Bank");
        System.out.println(" 2. Boutique");
        System.out.println(" 3. Clinic");
        System.out.println(" 4. Factory");
        System.out.println(" 5. Restaurant");
        System.out.println(" 6. Supermarket");
        System.out.println(" 7. Back to User Menu");

        Scanner scanner=new Scanner(System.in);
        int no= scanner.nextInt();
        boolean check4=true;
        while (check4) {

            switch (no) {

                case 1:

                    Game.city.getBanks().get(1).setOwnerID(avatar.getUsername());
                    Game.city.getBanks().get(1).setStatus(false);
                    avatar.getProperties().add(Game.city.getBanks().get(1));
                    avatar.setMoney(avatar.money-=Game.city.getBanks().get(1).getValue());
                    DataBase.updateInfo("bank","ownerID",1,avatar.getUsername());
                    DataBase.updateInfo("bank","status",1,false);
                    System.out.println("You buy this successfully");

                    check4=false;
                    break;

                case 2:

                    Game.city.getBoutiques().get(1).setOwnerID(avatar.getUsername());
                    Game.city.getBoutiques().get(1).setStatus(false);
                    avatar.getProperties().add(Game.city.getBoutiques().get(1));
                    avatar.setMoney(avatar.money-=Game.city.getBoutiques().get(1).getValue());
                    DataBase.updateInfo("boutique","ownerID",1,avatar.getUsername());
                    DataBase.updateInfo("boutique","status",1,false);
                    System.out.println("You buy this successfully");
                    check4=false;
                    break;

                case 3:
                    Game.city.getClinics().get(1).setOwnerID(avatar.getUsername());
                    Game.city.getClinics().get(1).setStatus(false);
                    avatar.getProperties().add(Game.city.getClinics().get(1));
                    avatar.setMoney(avatar.money-=Game.city.getClinics().get(1).getValue());
                    DataBase.updateInfo("clinic","ownerID",1,avatar.getUsername());
                    DataBase.updateInfo("clinic","status",1,false);
                    System.out.println("You buy this successfully");
                    check4=false;
                    break;

                case 4:

                    Game.city.getFactories().get(1).setOwnerID(avatar.getUsername());
                    Game.city.getFactories().get(1).setStatus(false);
                    avatar.getProperties().add(Game.city.getFactories().get(1));
                    avatar.setMoney(avatar.money-=Game.city.getFactories().get(1).getValue());
                    DataBase.updateInfo("factory","ownerID",1,avatar.getUsername());
                    DataBase.updateInfo("factory","status",1,false);
                    System.out.println("You buy this successfully");
                    check4=false;
                break;

                case 5:

                    Game.city.getRestaurants().get(1).setOwnerID(avatar.getUsername());
                    Game.city.getRestaurants().get(1).setStatus(false);
                    avatar.getProperties().add(Game.city.getRestaurants().get(1));
                    avatar.setMoney(avatar.money-=Game.city.getRestaurants().get(1).getValue());
                    DataBase.updateInfo("restaurant","ownerID",1,avatar.getUsername());
                    DataBase.updateInfo("restaurant","status",1,false);
                    System.out.println("You buy this successfully");
                    check4=false;
                    break;

                case 6:

                    Game.city.getSupermarkets().get(1).setOwnerID(avatar.getUsername());
                    Game.city.getSupermarkets().get(1).setStatus(false);
                    avatar.getProperties().add(Game.city.getSupermarkets().get(1));
                    avatar.setMoney(avatar.money-=Game.city.getSupermarkets().get(1).getValue());
                    DataBase.updateInfo("supermarket","ownerID",1,avatar.getUsername());
                    DataBase.updateInfo("supermarket","status",1,false);
                    System.out.println("You buy this successfully");
                    check4=false;
                    break;

                case 7:

                    Menu.showUserMenu();
                    check4 = false;
                    break;

                default:

                    System.out.println("try again");

            }
        }

    }
    public static void sell(String username){

        Avatar avatar = null;
        for (Avatar i:Game.city.getAvatars()){
            if (Objects.equals(i.getUsername(), username)){
                avatar=i;
                break;
            }
        }


        assert avatar != null;

//        Bank bank=null;
//        Boutique boutique=null;
//        Clinic clinic=null;
//        Factory factory=null;
//        Home home=null;
//        Land land=null;
//        Restaurant restaurant=null;
//        Supermarket supermarket=null;
//        if (no==1){
//            bank = Game.city.getBanks().get(1);
//        } else if (no==2) {
//            boutique = Game.city.getBoutiques().get(1);
//        } else if (no==3) {
//            clinic=Game.city.getClinics().get(1);
//        }
//        Object o=Property.FindProperty(no);
        Avatar.ShowProperty(username);
        System.out.println("Enter Property's id:");
        Scanner scanner=new Scanner(System.in);
        int no= scanner.nextInt();
        for (Property j: avatar.getProperties()){
            if (j.getId()==no){
                avatar.getProperties().remove(j);
//                j.setStatus(true);
//                j.setOwnerID(null);
//                avatar.setMoney(avatar.money+=j.getValue());
                DataBase.updateInfo("avatars","money",username,avatar.money+=j.getValue());
                System.out.println("Enter Property's description:");
                Scanner scanner10=new Scanner(System.in);
                String d=scanner10.nextLine();

                    DataBase.updateInfo( d ,"status",no,true);
                    DataBase.updateInfo( d ,"ownerID",no,"null");
                System.out.println("You successfully sell this property");
                break;
            }
        }
    }
    public static void Management(String username){

        Avatar avatar=null;
        for (Avatar i:Game.city.getAvatars()){
            if (Objects.equals(i.getUsername(), username)){
                avatar=i;
                break;
            }
        }
        assert avatar != null;
        for (Property i:avatar.getProperties()){
            System.out.println(i);
        }

        boolean check7=true;
        while (check7){
            System.out.println("What you want to do?");
            System.out.println("1. Change income:");
            System.out.println("2. Change Employee:");
            System.out.println("3. Back to User Menu:");
            Scanner s2=new Scanner(System.in);
            int num=s2.nextInt();
            if (num==1){

                Avatar.ShowProperty(username);

                Avatar avatar1=null;
                for (Avatar i:Game.city.getAvatars()){
                    if (Objects.equals(i.getUsername(), username)){
                        avatar1=i;
                        break;
                    }
                }

                Scanner s1=new Scanner(System.in);
                System.out.println("Which property do you want?(fist|second|third|...");
                int no=s1.nextInt();
                assert avatar1 != null;

                Property property=null;
                for (Property i: avatar1.getProperties()){
                    if (Objects.equals(i.getId(), avatar1.getProperties().get(no).getId())){
                        property=i;
                        break;
                    }
                }

                Bank bank = null;
                Boutique boutique = null;
                Clinic clinic = null;
                Factory factory = null;
                Home home = null;
                Land land = null;
                Restaurant restaurant = null;
                Supermarket supermarket = null;
                assert property != null;

                ///////////////////////////////////////
                for (Bank b : Game.city.getBanks()) {

                    if (b.getId() == property.getId()) {
                        bank=b;
                    }
                }
                if (bank!=null){
                    System.out.println("Enter NewSalary:");
                    Scanner input=new Scanner(System.in);
                    float newsalary= input.nextFloat();
                    bank.setSalary(newsalary);
                    DataBase.updateInfo("bank","salary", bank.getId(), newsalary);
                    System.out.println("Salary updated successfully!!!");
                }
                //////////////////////////////////////////
                for (Boutique b : Game.city.getBoutiques()) {
                    if (b.getId() == property.getId()) {
                        boutique=b;
                    }
                }
                if (boutique!=null){
                    System.out.println("Enter NewSalary:");
                    Scanner input=new Scanner(System.in);
                    float newsalary= input.nextFloat();
                    boutique.setSalary(newsalary);
                    DataBase.updateInfo("boutique","salary", boutique.getId(), newsalary);
                    System.out.println("Salary updated successfully!!!");
                }
                //////////////////////////////////////////////////
                for (Restaurant r : Game.city.getRestaurants()) {
                    if (r.getId() == property.getId()) {
                        restaurant=r;
                    }
                }
                if (restaurant!=null){
                    System.out.println("Enter NewSalary:");
                    Scanner input=new Scanner(System.in);
                    float newsalary= input.nextFloat();
                    restaurant.setSalary(newsalary);
                    DataBase.updateInfo("restaurant","salary", restaurant.getId(), newsalary);
                    System.out.println("Salary updated successfully!!!");
                }
                /////////////////////////////////////////////////////////
                for (Supermarket s : Game.city.getSupermarkets()) {
                    if (s.getId() == property.getId()) {
                        supermarket=s;
                    }
                }
                if (supermarket!=null){
                    System.out.println("Enter NewSalary:");
                    Scanner input=new Scanner(System.in);
                    float newsalary= input.nextFloat();
                    supermarket.setSalary(newsalary);
                    DataBase.updateInfo("supermarket","salary", supermarket.getId(), newsalary);
                    System.out.println("Salary updated successfully!!!");
                }
                /////////////////////////////////////////////////////

                for (Clinic c : Game.city.getClinics()) {
                    if (c.getId() == property.getId()) {
                        clinic=c;
                    }
                }
                if (clinic!=null){
                    System.out.println("Enter NewSalary:");
                    Scanner input=new Scanner(System.in);
                    float newsalary= input.nextFloat();
                    clinic.setSalary(newsalary);
                    DataBase.updateInfo("clinic","salary", clinic.getId(), newsalary);
                    System.out.println("Salary updated successfully!!!");
                }
                ////////////////////////////////////////////////////
                for (Factory f : Game.city.getFactories()) {
                    if (f.getId() == property.getId()) {
                        factory=f;
                    }
                }
                if (factory!=null){
                    System.out.println("Enter NewSalary:");

                    Scanner input=new Scanner(System.in);
                    float newsalary= input.nextFloat();
                    factory.setSalary(newsalary);
                    DataBase.updateInfo("bank","salary", factory.getId(), newsalary);
                    System.out.println("Salary updated successfully!!!");
                }
                ///////////////////////////////////////////////////////

                check7=false;
            } else if (num==2) {


                Avatar.ShowProperty(username);

                Avatar avatar2=null;
                for (Avatar i:Game.city.getAvatars()){
                    if (Objects.equals(i.getUsername(), username)){
                        avatar2=i;
                        break;
                    }
                }

                Scanner s1=new Scanner(System.in);
                System.out.println("Which property do you want?(fist|second|third|...");
                int no=s1.nextInt();
                assert avatar2 != null;

                Property property=null;
                for (Property i: avatar2.getProperties()){
                    if (Objects.equals(i.getId(), avatar2.getProperties().get(no).getId())){
                        property=i;
                        break;
                    }
                }
//                System.out.println(Avatar.employees);
//                System.out.println(Avatar.getEmployees().size());

                assert property != null;
                for (Avatar a:Game.city.getAvatars()){
                    if (a.getIndustryid()==property.getId()){
                        System.out.println(a);
                    }
                }


                System.out.println("Which Employee do you want to remove?(fist|second|third|...)");
                System.out.println("Enter employee's Username:");
                Scanner s3=new Scanner(System.in);
                String no1=s3.nextLine();

                Avatar avatar0=null;
                for (Avatar i:Game.city.getAvatars()){
                    if (Objects.equals(i.getUsername(), no1)){
                        avatar0=i;
                        break;
                    }
                }


                assert avatar0 != null;
                avatar0.setIncome(0);
                avatar0.setIndustryid(0);
                avatar0.setJob(null);
                DataBase.updateInfo("avatars","income",no1,0);
                DataBase.updateInfo("avatars","industryid",no1,0);
                DataBase.updateInfo("avatars","job",no1,null);
                System.out.println("This Employee removed successfully!!!");
                Menu.showUserMenu();
                check7=false;

            }
            else if (num==3){


                Menu.showUserMenu();

                check7=false;

            }
            else {
                System.out.println("Wrong choice!!! try again:");
            }
        }

    }

    public static void ShowProperty(String username){
        Avatar avatar=null;
        for (Avatar i:Game.city.getAvatars()){
            if (Objects.equals(i.getUsername(), username)){
                avatar=i;
                break;
            }
        }
        assert avatar != null;
        Avatar.showProperty(avatar);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public int getIndustryid() {
        return industryid;
    }

    public void setIndustryid(int industryid) {
        this.industryid = industryid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public static ArrayList<Avatar> getEmployees() {
        return employees;
    }

    public static void setEmployees(ArrayList<Avatar> employees) {
        Avatar.employees = employees;
    }

    public String getGender() {

        String gender1=gender.toString();

        return gender1;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public int getSleep() {
        return sleep;
    }

    public void setSleep(int sleep) {
        this.sleep = sleep;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public ArrayList<Property> getProperties() {
        return properties;
    }

    public void setProperties(ArrayList<Property> properties) {
        this.properties = properties;
    }

    public float getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(float coordinate) {
        this.coordinate = coordinate;
    }

    public float getWater() {
        return Water;
    }

    public void setWater(float water) {
        Water = water;
    }

    public float getFood() {
        return Food;
    }

    public void setFood(float foodandWater) {
        Food = foodandWater;
    }


    @Override
    public String toString() {
        return "Avatar{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", title='" + title + '\'' +
                ", gender=" + gender +
                ", money=" + money +
                ", coordinate=" + coordinate +
                ", health=" + health +
                ", sleep=" + sleep +
                ", job='" + job + '\'' +
                ", properties=" + properties +
                '}';
    }
}
