package org.example;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select language (en, fi, sv, ja):");
        String langSelection = scanner.nextLine().trim().toLowerCase();
        Locale locale;
        switch (langSelection) {
            case "fi":
                locale = new Locale("fi", "FI");
                break;
            case "sv":
                locale = new Locale("sv", "SE");
                break;
            case "ja":
                locale = new Locale("ja", "JP");
                break;
            default:
                locale = new Locale("en", "US");
                break;
        }
        ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", locale);

        System.out.println(messages.getString("enter.number.items"));
        int numberOfItems = Integer.parseInt(scanner.nextLine().trim());

        ShoppingCart cart = new ShoppingCart();
        for (int i = 1; i <= numberOfItems; i++) {
            System.out.println(messages.getString("enter.price") + " " + i + ":");
            double price = Double.parseDouble(scanner.nextLine().trim());
            System.out.println(messages.getString("enter.quantity") + " " + i + ":");
            int quantity = Integer.parseInt(scanner.nextLine().trim());
            cart.addItem(price, quantity);
        }

        double totalCost = cart.getTotalCost();
        System.out.println(messages.getString("total.cost") + " " + totalCost);
    }
}