package com.teamproject.busmate.service;

import com.teamproject.busmate.view.LoginMenu;

import java.util.Scanner;

public class BookingService {
    Scanner sc = new Scanner(System.in);
//    LoginMenu loginMenu = new LoginMenu();

    public void bookTicket(){
        System.out.println("---------------------------------------------------");

        while(true){
            System.out.println("1. Enter your From Location : ");
            System.out.println("1. Chennai");
            System.out.println("2. Coimbatore");
            System.out.println("3. Selam");
            System.out.println("4. Tenkasi");
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
//                    loginMenu.displayLogin();
                    break;
                case 2:
//                    loginMenu.displayRegister();
                    break;
                case 3:
                    System.out.println("Thank you for using BusMate");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }


    }
}
