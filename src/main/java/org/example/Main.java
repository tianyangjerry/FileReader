package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("Groceries.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            double totalPrice = 0;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                String id = parts[0];
                String itemName = parts[1];
                String quantity = parts[2];
                double price = Double.parseDouble(parts[3]);
                totalPrice += Integer.parseInt(quantity.substring(0, 1)) * price;
                System.out.println("ID: " + id + ", Item Name: " +
                        itemName + ", Quantity: " + quantity + ", Price: " + price);
            }
            System.out.println("Total Price: " + totalPrice);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
