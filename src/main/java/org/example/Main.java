package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        FileWriter fileWriter = null;
        try {

            FileReader fileReader = new FileReader("Groceries.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            fileWriter = new FileWriter("GroceriesFormatted.txt");

            fileWriter.write("****************************************************");
            fileWriter.write("\nID# Item Quantity Price (€).\n");
            String line;
            double totalPrice = 0;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                String id = parts[0];
                String itemName = parts[1];
                String quantity = parts[2];
                double price = Double.parseDouble(parts[3]);
                totalPrice += Integer.parseInt(quantity.substring(0, 1)) * price;
                fileWriter.write(String.format("%-5s%-10s%-10s%-10s\n", id, itemName, quantity, price));
                System.out.println("ID: " + id + ", Item Name: " +
                        itemName + ", Quantity: " + quantity + ", Price: " + price);
            }

            fileWriter.write("****************************************************");
            fileWriter.write("\nThe grocery shopping total is: €" + totalPrice);

            System.out.println("Total Price: " + totalPrice);
        } catch (IOException e) {
            throw new RuntimeException("File not found");
        } finally {
            System.out.println("File has been formatted successfully.");
            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                throw new RuntimeException("Error closing file");
            }
        }
    }
}
