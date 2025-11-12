package com.teamproject.busbooking.ui;
import java.util.Scanner;
public class WelcomeMenu {
    public void displayMenu() {
       while(true){
           System.out.println("Welcome to Bus Booking System");
           System.out.println("1. Login");
           System.out.println("2. Register");
           System.out.println("3. Exit");
           System.out.println("Enter your choice: ");
           Scanner scanner = new Scanner(System.in);
           int choice = scanner.nextInt();
           switch (choice) {
               case 1:
                   LoginMenu loginMenu = new LoginMenu();
                   loginMenu.displayMenu();
                   break;
               case 2:
                   RegisterMenu registerMenu = new RegisterMenu();
                   registerMenu.displayMenu();
                   break;
               case 3:
                   break;
           }
       }
    }

}
