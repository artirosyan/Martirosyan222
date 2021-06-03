package adportal;


import adportal.adModel.Ad;
import adportal.adModel.Category;
import adportal.adModel.Gender;
import adportal.adModel.User;
import adportal.storage.Adstorage;
import adportal.storage.UserStorage;
import adportal.storage.impl.AdSrorageimpl;
import adportal.storage.impl.UserStoradeImple;

import java.util.Date;
import java.util.Scanner;

public class AdPortalTest implements Commands {

    private static Scanner scanner = new Scanner(System.in);
    private static Adstorage adstorage = new AdSrorageimpl();
    private static UserStorage userStorage = new UserStoradeImple();
    private static User crrentUser = null;

    public static void main(String[] args) {

        boolean isRun = true;
        while (isRun) {
            Commands.printMainCommads();
            int command;
            try {
                command = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                command = -1;
            }
            switch (command) {
                case EXIT:
                    isRun = false;
                    break;
                case LOGIN:
                    login();
                    break;
                case REGISTER:
                    register();
                    break;
                case MAIN_PRINT_ALL_ADS:
                    printAllAds();
                    break;
                default:
                    System.out.println("invalid command, please try again!");
            }
        }

    }

    private static void printAllAds() {
        adstorage.pritAllAds();
    }

    private static void register() {
        System.out.println("Please input name, surname, gender, age, phoneNumber, password");
        String userData = scanner.nextLine();
        String[] userDataArr = userData.split(",");
        User user = new User(userDataArr[0], userDataArr[1], Gender.valueOf(userDataArr[2]),
                Integer.parseInt(userDataArr[3]), userDataArr[4], userDataArr[5]);
        userStorage.add(user);
        System.out.println("Register was success!");
    }


    private static void login() {
        System.out.println("Please input phone number, password");
        String userCred = scanner.nextLine();
        String[] userDataArr = userCred.split(",");
        User user = userStorage.getByPhone(userDataArr[0]);
        if (user == null) {
            System.out.println("User does not exists!");
        } else {
            if (user.getPassword().equals(userDataArr[1])) {
                System.out.println("Welcome " + user.getName() + "!");

                userLogin();
            } else {
                System.out.println("password is incorrect !");
            }
        }
    }

    private static void userLogin() {
        boolean isRun = true;
        while (isRun) {
            Commands.printUserCommands();
            int commands;
            try {
                commands = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException k) {
                commands = -1;
            }
            switch (commands) {
                case LOGAOUT:
                    crrentUser = null;
                    isRun = false;
                    break;
                case ADD:
                    addAd();
                    break;
                case PRINT_ALL_ADS:
                    printAllAds();
                    break;
                case PRINT_ALL_MY_ADS:
                    adstorage.printMyAds(crrentUser);
                    break;
                case PRINT_ADS_BY_CATEGORY:
                    printAddByCategory();
                    break;
                case DELETE_MY_ALL_ADS:
                    adstorage.deleteMyAds(crrentUser);
                    break;
                case DELETE_MY_AD_BY_TITLE:
                    deledMyAdByTitle();
                    break;
                default:
                    System.out.println("Wrrong command");

            }
        }
    }

    private static void deledMyAdByTitle() {
        System.out.println("Please selecct your ad title");
        adstorage.printMyAds(crrentUser);
        String title = scanner.nextLine();
        adstorage.deleteAdByTitle(title, crrentUser);

    }

    private static void printAddByCategory() {
        System.out.println("Here is the categoryList");
        for (Category value : Category.values()) {
            System.out.println(value);
        }
        String categoryStr = scanner.nextLine();
        adstorage.printByCategory(Category.valueOf(categoryStr));
    }

    private static void addAd() {
        System.out.println("Please input title, text, price, category");
        System.out.println("Here is the categoryList");
        for (Category value : Category.values()) {
            System.out.println(value);
        }
        String adData = scanner.nextLine();
        String[] adDataArr = adData.split(",");
        Ad ad = new Ad(adDataArr[0], adDataArr[1], Double.parseDouble(adDataArr[2]), new Date(),
                Category.valueOf(adDataArr[3]), crrentUser);
        adstorage.add(ad);
        System.out.println("Ad was added");
    }
}

