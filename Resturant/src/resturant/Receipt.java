/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resturant;

/**
 *
 * @author hp
 */

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author hp
 */
public class Receipt extends Resturant{
    public static void saveOrderToFile(String foodName, int quantity, float totalAmount, boolean isPremium) {
        try (FileWriter writer = new FileWriter("order.txt", true)) {
            writer.write("Order Details:\n");
            writer.write("Food Item: " + foodName + "\n");
            writer.write("Quantity: " + quantity + "\n");
            writer.write("Total Amount: " + totalAmount + " LKR\n");
            writer.write("Customer Type: " + (isPremium ? "Premium" : "Standard") + "\n");
            writer.write("----------------------------\n");
            System.out.println("\n\t\tReceipt details saved to order.txt \n");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the order details.");
            e.printStackTrace();
        }
    }
}

