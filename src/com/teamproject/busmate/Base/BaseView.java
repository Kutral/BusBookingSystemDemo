package com.teamproject.busmate.Base;

import java.util.Scanner;

public class BaseView {
    public void print(String message) {
        System.out.println(message);
    }
    public void printAll(String[] message) {
        for (String s : message) {
            System.out.println(s);
        }
    }
    public String printQuestion(String question, Scanner scanner) {
        System.out.println(question);
        return scanner.next();

    }

}
