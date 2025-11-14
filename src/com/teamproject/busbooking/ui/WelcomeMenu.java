package com.teamproject.busbooking.ui;
import java.util.Scanner;
public class WelcomeMenu {
    public void displayMenu() {
       while(true){
           System.out.println("Welcome to BusMate");
           System.out.println("1. Login");
           System.out.println("2. Register");
           System.out.println("3. Exit");
           System.out.println("Enter your choice: ");
           Scanner scanner = new Scanner(System.in);
           int choice = scanner.nextInt();
           LoginMenu loginMenu = new LoginMenu();
           switch (choice) {
               case 1:
                   //loginMenu.displayLogin();
                   break;
               case 2:
                   loginMenu.displayRegister();
                   break;
               case 3:
                   System.out.println("Thank you for using BusMate");
                   System.exit(0);
               default:
                   break;
           }
       }
    }

}
