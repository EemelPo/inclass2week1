package org.example;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final List<Item> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(double price, int quantity) {
        items.add(new Item(price, quantity));
    }

    public double getTotalCost() {
        return items.stream()
                .mapToDouble(Item::getTotal)
                .sum();
    }

    private static class Item {
        private final double price;
        private final int quantity;

        public Item(double price, int quantity) {
            this.price = price;
            this.quantity = quantity;
        }

        public double getTotal() {
            return price * quantity;
        }
    }
}