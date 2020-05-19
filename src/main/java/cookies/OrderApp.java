package cookies;

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

        System.out.println(orders.getTotalBoxes());

        orders.showOrder();
        String varietyToRemove = "Thin Mints";
        System.out.println("You are removing " + orders.getVarietyBoxes(varietyToRemove) +
                " " + varietyToRemove);
        orders.removeVariety("Thin Mints");

        orders.showOrder();
        
    }
}
