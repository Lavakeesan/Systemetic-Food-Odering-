/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resturant;

/**
 *
 * @author hp
 */


/**
 *
 * @author hp
 */
public class Discount {
    public static float calculate(float t_price) {
        final float DISCOUNT = 0.25f;
        float discountAmount = t_price * DISCOUNT;
        float finalAmount = t_price - discountAmount;
        System.out.println("\t\t The discount amount: " + discountAmount + " LKR");
        System.out.println("\t\t The final amount after discount is: " + finalAmount + " LKR");
        return finalAmount;
    }
}

