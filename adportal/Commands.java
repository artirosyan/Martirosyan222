package adportal;

public interface Commands {

    int EXIT = 0;
    int LOGIN = 1;
    int REGISTER = 2;
    int MAIN_PRINT_ALL_ADS = 3;

    int LOGAOUT = 0;
    int ADD = 1;
    int PRINT_ALL_ADS = 2;
    int PRINT_ALL_MY_ADS = 3;
    int PRINT_ADS_BY_CATEGORY = 4;
    int DELETE_MY_ALL_ADS = 5;
    int DELETE_MY_AD_BY_TITLE = 6;


    static void printMainCommads() {

        System.out.println("Please imput " + EXIT + " for Exit");
        System.out.println("Please imput " + LOGIN + " for Login");
        System.out.println("Please imput " + REGISTER + " for Register");
        System.out.println("Please imput " + MAIN_PRINT_ALL_ADS + " for Print all ads");

    }

    static void printUserCommands(){
        System.out.println("Please imput " + LOGAOUT + " for Logauot");
        System.out.println("Please imput " + ADD + " for Add");
        System.out.println("Please imput " + PRINT_ALL_ADS + " for Print all ads");
        System.out.println("Please imput " + PRINT_ALL_MY_ADS + " for Print all my ads");
        System.out.println("Please imput " + PRINT_ADS_BY_CATEGORY + " for Print ads by category");
        System.out.println("Please imput " + DELETE_MY_ALL_ADS + " for  Delet my all ads");
        System.out.println("Please imput " + DELETE_MY_AD_BY_TITLE + " for Delet my ad by title");

    }
}
