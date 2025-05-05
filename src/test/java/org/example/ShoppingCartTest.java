package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingCartTest {

    @Test
    public void testSingleItemTotal() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(10.0, 2);
        assertEquals(20.0, cart.getTotalCost(), 0.001);
    }

    @Test
    public void testMultipleItemsTotal() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(5.5, 3);
        cart.addItem(10.0, 1);
        cart.addItem(2.0, 5);
        assertEquals(36.5, cart.getTotalCost(), 0.001);
    }
}