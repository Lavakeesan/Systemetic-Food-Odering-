/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resturant;

/**
 *
 * @author hp
 */

import java.util.Scanner;

/**
 *
 * @author hp
 */
public class Resturant {

    public static void main(String[] args) {
        System.out.println("\t\t\t BLV Resturant ");
        Premium_Customer();
    }

    public static void Premium_Customer(){
        int num;
        Scanner scan = new Scanner(System.in);
        System.out.println("Do you have Premium Account.");
        System.out.println("'1' for Yes.\n'2' for No.");
        System.out.print("Enter your choice: ");
        num = scan.nextInt();

        switch(num) {
            case 1:
                System.out.println("\tPlease login with your premium account.");
                login();
                break;
            case 2:
                System.out.println("You are a Standard Customer.");
                System.out.println("Now you can order your food.");
                food_order(false);
                break;
            default:
                System.out.println("Invalid Input.");
                break;
        }
    }

    public static void login() {
        String name = "premium";
        String pin = "1234";

        Scanner scan = new Scanner(System.in);
        System.out.print("\tEnter your premium account username: ");
        String user_name = scan.nextLine();
        System.out.print("\tEnter the pin number: ");
        String pin_no = scan.nextLine();

        if(name.equals(user_name) && pin.equals(pin_no)) {
            System.out.println("\n\t\t\t\t Welcome!");
            food_order(true);
        } else {
            System.out.println("Incorrect username or pin number.");
            login();
        }
    }

    public static void food_order(boolean isPremium) {
        Food_Menu menu = new Food_Menu();
        System.out.println("\n\t\t\tThis is the menu card.");
        for(int i = 0; i < menu.food_name.length; i++) {
            System.out.println("\t\t" + (i+1) + ". " + menu.food_name[i] + " :- " + menu.food_price[i] + " LKR");
        }
        take_order(isPremium);
    }

    public static void take_order(boolean isPremium) {
        Food_Menu menu = new Food_Menu();
        System.out.println("\n\tSelect your order.");
        for(int j = 1; j <= menu.food_name.length; j++) {
            System.out.println("\t\t '" + j + "' for " + menu.food_name[j-1]);
        }

        Scanner scan = new Scanner(System.in);
        System.out.print("\t Enter your choice: ");
        int choice = scan.nextInt();

        if(choice >= 1 && choice <= menu.food_name.length) {
            dish_amount(menu.food_name[choice-1], menu.food_price[choice-1], isPremium);
        } else {
            System.out.println("Invalid input.");
            take_order(isPremium);
        }
    }

    public static void dish_amount(String f_name, float f_price, boolean isPremium) {
        Scanner scan = new Scanner(System.in);
        System.out.print("\t How many " + f_name + " dishes you want:");
        int dish_count = scan.nextInt();

        System.out.println("\n\t\t One plate " + f_name + " price: " + f_price + " LKR");
        price_amount(f_price, dish_count, f_name, isPremium);
    }

    public static void price_amount(float fo_price, int quantity, String fo_name, boolean isPremium) {
        float total_amount = quantity * fo_price;
        System.out.println("\t\t" + fo_name + " dishes price is: " + total_amount + " LKR");

        if(isPremium) {
            total_amount = Discount.calculate(total_amount);
        }

        Receipt.saveOrderToFile(fo_name, quantity, total_amount, isPremium);
    }
}
