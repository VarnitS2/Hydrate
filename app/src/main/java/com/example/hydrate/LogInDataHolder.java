package com.example.hydrate;

import java.util.ArrayList;

public class LogInDataHolder {

    /** Username of current logged in user. */
    public static String USERNAME;

    /** All registered emails. */
    public static ArrayList<String> EMAILS = new ArrayList<>();

    /** All registered passwords. */
    public static ArrayList<String> PASSWORDS = new ArrayList<>();

    /** All registered usernames. */
    public static ArrayList<String> USERNAMES = new ArrayList<>();

    /** Login flag check. */
    public static boolean LOGINFLAG;

    /** Holder for checked button. */
    public static int buttonID;
}
