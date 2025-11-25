package com.teamproject.busmate;

import com.teamproject.busmate.view.WelcomeMenu;

import java.util.Scanner;

public class BusMate {
    public static final String version= "0.0.5";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------------------------------------");
        System.out.println("Welcome to BusMate - " +  version);
        System.out.println("-----------------------------------------");
        WelcomeMenu welcomeMenu = new WelcomeMenu(scanner);
        welcomeMenu.displayMenu();
        scanner.close();
    }
}
