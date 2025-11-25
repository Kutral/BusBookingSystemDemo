package com.teamproject.busmate.Constants;

public interface constants {
    public static String[] AdminMenu = {"-----------------------------------------","Admin Menu",
            "1. Add Bus","2.View All Buses","3.Search bus","4.Delete bus","5.Exit",
            "-----------------------------------------","Enter your choice: "};
    public static String[] UserMenu = {"\nUser Menu", "1. Book a Ticket", "2. View My Bookings", "3. Logout", "Enter your choice: "};
    public static String[] RegisterMenu = {"-----------------------------------------", "You are in Register Menu : ", "Enter username:", "Enter password:", "Enter email:", "-----------------------------------------"};
    public static String[] LoginMenu = {"-----------------------------------------", "You are in Login Menu :", "Enter username: ", "Enter password: ", "-----------------------------------------"};
    public static String[] WelcomeMenu = {"1. Login", "2. Register", "3. Exit", "-----------------------------------------", "Enter your choice: "};
    public static String ThankYouMessage = "Thank you for using BusMate";
    public static String InvalidChoiceMessage = "Invalid choice. Please try again.";
}
