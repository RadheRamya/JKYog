/*
package com.jkyog.automation.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface RegExpUtility {

    public static boolean isPhoneNumberValid(String phnNumber) {
        String regExpPattern = "(0|91)?[6-9][0-9]{9}";
        boolean status = true;
        Pattern pattern = Pattern.compile(regExpPattern);
        Matcher matcher = pattern.matcher(phnNumber);

        if (matcher.find() && matcher.group().equalsIgnoreCase(phnNumber)) {
            System.out.println("It is a valid phone number: " + phnNumber);
        } else {
            System.out.println("It is a Not valid phone number: " + phnNumber);
            status = false;
        }
        return status;
       }

    public static boolean isEmailValid(String email) {
        String regExpPattern = "[A-Za-z0-9+_.-]+@(.+)$";
        boolean status = true;
        Pattern pattern = Pattern.compile(regExpPattern);
        Matcher matcher = pattern.matcher(email);

        if (matcher.find() && matcher.group().equalsIgnoreCase(email)) {
            System.out.println("It is a valid phone number: " + email);
        } else {
            System.out.println("It is a Not valid phone number: " + email);
            status = false;
        }
        return status;
    }
*/
/**//*

    //(0|91)?[6-9][0-9]{9}
    //[A-Za-z0-9+_.-]+@(.+)$
}
*/
