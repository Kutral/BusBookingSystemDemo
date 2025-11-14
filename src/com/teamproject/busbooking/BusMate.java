package com.teamproject.busbooking;

import com.teamproject.busbooking.view.WelcomeMenu;


public class BusMate {
    public static final String version= "0.0.2";

    public static void main(String[] args) {
        System.out.println("Welcome to BusMate - " +  version);
        WelcomeMenu welcomeMenu = new WelcomeMenu();
        welcomeMenu.displayMenu();
    }
}


