package com.steam.util;

import java.util.Random;

public class RandomCode {

    public static String generateConfirmCode(){
        Random random = new Random();

        int min = 111111;
        int max = 999999;

        int code = random.nextInt(max - min + 1) + min;

        return String.valueOf(code);
    }

}
