package org.example.models;

import org.example.Database;
import org.example.defualtSystem.Bank;
import org.example.defualtSystem.Life;
import org.example.defualtSystem.Municipality;
import org.example.defualtSystem.StockMarket;
import org.example.interfaces.CityInterface;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class City implements CityInterface {
    private final ArrayList<Character> characters;
    private final Bank bankSystem;
    private final Municipality municipality;

    private final StockMarket stockMarket;

    private Character root;

    public City() {
        characters = new ArrayList<>();
        municipality = new Municipality();
//        Get Bank Property from municipality
        bankSystem = new Bank(new Property(new float[]{12, 32}, new float[]{42, 32}, root), root);
        stockMarket = new StockMarket();
        stockMarket.startMarketSimulation();
    }
    /**
     * Begin Game function generate a new thread for each character ,<b > DO NOT CHANGE THIS FUNCTION STRUCTURE</b> ,
     *
     * */
    @Override
    public void joinCharacter(User userinfo) {
        try {
            BankAccount newAccount = bankSystem.newAccount(userinfo.getUsername(), userinfo.getPassword());
            Database.createBankAccount(newAccount);
            Character character = new Character(userinfo, newAccount, new Life(), null, null, null);
            characters.add(character);
            Database.saveCharacter(character);
            beginGame(character);
        }
        catch (Exception e){
            System.out.println("user not found!");
        }
    }

    private void beginGame(Character character) {
    }

    @Override
    public void getCityDetail() {
        String players = Arrays.toString(characters.toArray());
    }


    /**
     * Begin Game function generate a new thread for each character ,<b > DO NOT CHANGE THIS FUNCTION STRUCTURE</b> ,
     */
//    public void beginGame(Character character) {
////        using thread to save details for prevent from unsaved change due to system shutdown
//        Thread savingLife = new Thread(() -> {
//            while (true) {
//                Database.updateCharacter("life", character);
//                try {
//                    Thread.sleep(60000 * 2); // save each 2 minute
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        savingLife.start();
//
//        Thread thread = new Thread(() -> {
//            try {
//                Scanner scanner = new Scanner(System.in);
//                System.out.println("panel menu");
//                System.out.println("1. go to place     ");
//                System.out.println("2. process location");
//                System.out.println("3. dashboard       ");
//                System.out.println("4. life            ");
//                System.out.println("5. exit            ");
//                System.out.println("**************************************");
//                System.out.println("enter your command : ");
//                while (true) {
//                    switch (scanner.next()) {
//                        case "1" -> GoTo(character);
//                        case "2" -> Process_location(character);
//                        case "3" -> Dashboard(character);
//                        case "4" -> Life(character);
//                        case "5" -> {
//                            System.out.println("are you sure?[yes/no]");
//                            if (scanner.next().equals("yes")) {
//                                System.exit(1);
//                            } else {
//                                beginGame(character);
//                            }
//                        }
//                    }
//                }
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//        });
//        thread.start();
//    }
    public void Life(Character character) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("life menu");
        System.out.println("*      life detail         [1]      *");
        System.out.println("*      sleep option        [2]      *");
        System.out.println("*      eat option          [3]      *");
        System.out.println("*      back                [4]      *");
        System.out.println("enter number: ");
        switch (scanner.next()) {
            case "1" -> Life_Detail(character);
            case "2" -> Sleep(character);
            case "3" -> Eat(character);
            case "4" -> beginGame(character);
        }
    }
//    public void GoTo(Character character) {
//        System.out.println("***************************************");
//        System.out.println("****         go to place           ****");
//        System.out.println("***************************************");
//        municipality.showProperties(character, Database.LoadProperties());
//        System.out.println("Tip: if you want travel by coordinate write in this order :(divide it by comma) X,Y");
//
//        Scanner MyPlace = new Scanner(System.in);
//        String place = MyPlace.nextLine();
//        String placeX = "", placeY = "";
//        float locationX = 0.0f, locationY = 0.0f;
//        System.out.println(place);
//        if (place.contains(",")) {
//            String[] placeXY = place.split(",");
//            placeX = placeXY[0];
//            placeY = placeXY[1];
//
//            locationX = Float.parseFloat(placeX);
//            locationY = Float.parseFloat(placeY);
//        }
//
//        Property location = null;
//        boolean isWrongData = false;
//        for (Property property : Database.LoadProperties()) {
//            if (property.getIndustryTitle().equals(place)) {
//                location = property;
//                isWrongData = true;
//            } else if (String.valueOf(property.getId()).equals(place)) {
//                isWrongData = true;
//                location = property;
//            } else if (locationX == property.getCoordinate()[0] && locationY == property.getCoordinate()[1]) {
//                isWrongData = true;
//                location = property;
//            }
//
//        }
//        if (!isWrongData) {
//            System.out.println("You Enter details wrongly !");
//            System.out.println("please enter again...");
//            GoTo(character);
//        }
//        character.gotToLocation(location);
//        character.positionProcessing();
//
//    }
    public void Life_Detail(Character character) {
        Scanner lifeDetails = new Scanner(System.in);
        System.out.println("*  you can manage and check your life status :  *");
        System.out.println("*  food  : " + character.getLife().getFood() + "  *");
        System.out.println("*  water : " + character.getLife().getWater() + "  *");
        System.out.println("*  sleep : " + character.getLife().getSleep() + "  *");
        System.out.println("*************");
        System.out.println("*  take a nap              [1] *");
        System.out.println("*  eat or drink            [2] *");
        System.out.println("*  back                    [3] *");
        System.out.println("enter your command:");
        switch (lifeDetails.next()) {
            case "1" -> Sleep(character);
            case "2" -> Eat(character);
            case "3" -> Life(character);
        }
    }

    public void Sleep(Character character) {
        Scanner sleep = new Scanner(System.in);
        System.out.println("* we have some plan for you *");
        System.out.println("* sleep : " + character.getLife().getSleep() + "  *");
        System.out.println("* +10 for 1$           [1]  *");
        System.out.println("* +20 for 2$           [2]  *");
        System.out.println("* +30 for 2.5$         [3]  *");
        System.out.println("* cancel and back      [4]  *");
        System.out.println("enter your command:");
        switch (sleep.next()) {
            case "1" -> sleepCharge(character, 10, 1);
            case "2" -> sleepCharge(character, 20, 2);
            case "3" -> sleepCharge(character, 30, 2.5f);
            case "4" -> Life_Detail(character);
        }
        System.out.println("************");
        System.out.println("what do you want?");
        System.out.println("*  charge again     [1]  *");
        System.out.println("*  back             [2]  *");
        switch (sleep.next()) {
            case "1" -> Sleep(character);
            case "2" -> Life_Detail(character);
        }
    }

    private void sleepCharge(Character character, float moreSleep, float price) {
        BankAccount account = character.getAccount();
        account.withdraw(character, price);

        float lastSleep = character.getLife().getSleep();
        float nowSleep = lastSleep + moreSleep;
        if (nowSleep >= 100) {
            nowSleep = 100.0f;
        }

        Life temp = character.getLife();
        temp.setSleep(nowSleep);

        Database.updateCharacter("life", character);

        System.out.println("your new sleep status is :" + temp.getSleep());
    }

    public void Eat(Character character) {
        Scanner foodScan = new Scanner(System.in);
        System.out.println("you can consume product to gain water or food");
        System.out.println("* travel and shop          [1] *");
        System.out.println("* cancel and back          [2] *");

        switch (foodScan.next()) {
            case "1" -> GoTo(character);
            case "2" -> Life_Detail(character);
        }
    }

    private void GoTo(Character character) {
    }
}
