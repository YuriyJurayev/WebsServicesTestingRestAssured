package kz.epam.webservices.utils;

import kz.epam.webservices.model.user.User;

public class ConsolePrinter {

    public static void printString(String toPrint){
        System.out.println(toPrint);
    }
    public static void printInteger(Integer toPrint){
        System.out.println(toPrint);
    }

    public static void printUsersInfo(User[] users){
        for(User user: users){
            System.out.println(user.toString());
        }
    }
}
