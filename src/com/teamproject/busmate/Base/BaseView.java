package com.teamproject.busmate.Base;

import java.util.Scanner;


public abstract class BaseView {
    public void print(String message) {
        System.out.println(message);
    }
    public void printAll(String[] message) {
        for (String s : message) {
            System.out.println(s);
        }
    }
    Scanner scanner = new Scanner(System.in);
    public String printQuestion(String question) {
        System.out.println(question);
        return scanner.next();

    }

}
