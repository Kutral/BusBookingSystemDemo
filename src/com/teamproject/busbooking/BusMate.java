package com.teamproject.busbooking;

import com.teamproject.busbooking.ui.WelcomeMenu;


public class BusMate {
    public static final String version= "0.0.1";

    public static void main(String[] args) {
        System.out.println("Welcome to BusMate - " +  version);
        WelcomeMenu welcomeMenu = new WelcomeMenu();
        welcomeMenu.displayMenu();
    }
}


