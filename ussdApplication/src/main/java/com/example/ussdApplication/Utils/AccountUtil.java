package com.example.ussdApplication.Utils;

import java.util.Random;

public class AccountUtil {
    public static int generateAccountNumber(){
        Random random = new Random();
        int accountNumber = random.nextInt(900000000)+1000000000;
        return accountNumber;
    }


//    public static int generatePin(){
//        Random random = new Random();
//        int accountPin = random.nextInt(400) + 1000;
//        return  accountPin;
//    }
}
