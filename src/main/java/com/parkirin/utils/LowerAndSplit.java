package com.parkirin.utils;

public class LowerAndSplit {
    public static String lowNonSpace(String input){
        String result = input.replaceAll(" ","").toLowerCase();
        return result;
    }
}
