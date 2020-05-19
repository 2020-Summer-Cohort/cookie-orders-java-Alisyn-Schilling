package cookies;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MasterOrderTest {
    @Test
    public void addOrder(){
        CookieOrder order1 = new CookieOrder("Tagalongs", 3);
        assertEquals("Tagalongs", order1.getVariety());
        assertEquals(3, order1.getNumBoxes());
    }
    @Test
    public void getVarietyBoxes(){
        CookieOrder order1 = new CookieOrder("Tagalongs", 3);
        MasterOrder orders = new MasterOrder();
        orders.addOrder(order1);
        assertEquals(3, orders.getVarietyBoxes("Tagalongs"));
    }
    @Test
    public void getTotalBoxes(){
        CookieOrder order1 = new CookieOrder("Tagalongs", 3);
        MasterOrder orders = new MasterOrder();
        orders.addOrder(order1);
        assertEquals(3, orders.getTotalBoxes());
    }
    @Test
    public void removeVariety(){
        CookieOrder order1 = new CookieOrder("Tagalongs", 3);
        MasterOrder orders = new MasterOrder();
        orders.addOrder(order1);
        orders.removeVariety("Tagalongs");
        assertEquals(0, orders.getTotalBoxes());
    }
}
