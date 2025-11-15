package com.teamproject.busmate;

import com.teamproject.busmate.view.WelcomeMenu;

public class BusMate {
    public static final String version= "0.0.3";

    public static void main(String[] args) {
        System.out.println("-----------------------------------------");
        System.out.println("Welcome to BusMate - " +  version);
        System.out.println("-----------------------------------------");
        //test
        WelcomeMenu welcomeMenu = new WelcomeMenu();
        welcomeMenu.displayMenu();
    }
}


