package cookies;

import java.sql.SQLOutput;
import java.util.Scanner;

public class OrderApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MasterOrder orders = new MasterOrder();
        CookieOrder order1 = new CookieOrder("Tagalongs", 3);
        orders.addOrder(order1);
        CookieOrder order2 = new CookieOrder("Thin Mints", 5);
        orders.addOrder(order2);
        CookieOrder order3 = new CookieOrder("Samoas", 3);
        orders.addOrder(order3);
        CookieOrder order4 = new CookieOrder("Thin Mints", 6);
        orders.addOrder(order4);


        while (true) {
            orders.showOrder();
             int input = userInteraction(scanner, orders);

            if (input == 0){
                break;
            }
        }

    }
    public static int userInteraction(Scanner scanner, MasterOrder orders){
        System.out.println("What would you like to do?\n" +
                "\n" +
                "1: Place an order\n" +
                "2: Remove an item.\n" +
                "0: Exit\n");
        int input = scanner.nextInt();
        input = getHelp(scanner, input);
        if (input == 1){
            placeOrder(scanner, orders);
        } else if (input == 2){
            removeOrder(scanner, orders);
        } else if (input == 0){
            System.out.println("Exiting");
        }
        return input;

    }
    public static int getHelp(Scanner scanner, int input){
        while ((input < 0) || (input > 3)){
            System.out.println("Please enter a number between 0 and 2");
            input = scanner.nextInt();
        }
        return input;
    }
    public static void placeOrder(Scanner scanner, MasterOrder orders){
        System.out.println("Please select a type of cookie.\n" +
                "\n" +
                "1: Tagalong\n" +
                "2: Thin Mints\n" +
                "3: Peanut Crisp\n" +
                "0: Exit");
        int input = scanner.nextInt();
        input = getCookieHelp(scanner, input);
        String cookieType = "";
        int cookieQty = 0;
        if (input == 1){
            cookieQty = orderQty(scanner);
            cookieType = "Tagalongs";
        } else if (input == 2){
            cookieQty = orderQty(scanner);
            cookieType = "Thin Mints";
        } else if (input == 3){
            cookieQty = orderQty(scanner);
            cookieType = "Peanut Crisp";
        }
        if (input != 0){
            CookieOrder order = new CookieOrder(cookieType, cookieQty);
            orders.addOrder(order);
        }

    }
    public static int orderQty(Scanner scanner){
        System.out.println("And how many would you like?");
        return scanner.nextInt();
    }
    public static int getCookieHelp(Scanner scanner, int input){
        while ((input < 0) || (input > 4)){
            System.out.println("Please enter a number between 0 and 3");
            input = scanner.nextInt();
        }
        return input;
    }
    public static void removeOrder(Scanner scanner, MasterOrder orders) {
        System.out.println("Please select a type of cookie to remove from the order.\n" +
                "\n" +
                "1: Tagalong\n" +
                "2: Thin Mints\n" +
                "3: Peanut Crisp\n" +
                "0: Exit");
        int input = scanner.nextInt();
        input = getCookieHelp(scanner, input);
        if (input == 1) {
            System.out.println("You are removing " + orders.getVarietyBoxes("Tagalongs") +
                    " Tagalongs");
            orders.removeVariety("Tagalongs");

        } else if (input == 2) {
            System.out.println("You are removing " + orders.getVarietyBoxes("Thin Mints") +
                    " Thin Mints");
            orders.removeVariety("Thin Mints");
        } else if (input == 3) {
            System.out.println("You are removing " + orders.getVarietyBoxes("Peanut Crisp") +
                    " Peanut Crisp");
            orders.removeVariety("Peanut Crips");
        }
    }
}
