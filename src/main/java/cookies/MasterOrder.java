package cookies;

import java.util.ArrayList;

public class MasterOrder {
    private ArrayList<CookieOrder> orders = new ArrayList<>();

    public MasterOrder() {

    }

    public void addOrder(CookieOrder theOrder) {
        orders.add(theOrder);
    }

    public int getTotalBoxes() {
        int totalBoxes = 0;
        for (CookieOrder order : orders) {
            totalBoxes += order.getNumBoxes();
        }
        return totalBoxes;
    }

    public void removeVariety(String variety) {
        orders.removeIf(order -> order.getVariety().equals(variety));
    }

    public int getVarietyBoxes(String variety) {
        int varietyBoxes = 0;
        for (CookieOrder order : orders) {
            if (order.getVariety().equals(variety)) {
                varietyBoxes += order.getNumBoxes();
            }
        }
        return varietyBoxes;
    }

    public void showOrder() {
        System.out.println("Current Order");
        for (CookieOrder order : orders) {
            System.out.println(order.getVariety() + ": " + order.getNumBoxes() + " boxes");
        }
    }

}
