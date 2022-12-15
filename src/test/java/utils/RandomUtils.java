package utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    public static void main(String[] args) {
        System.out.println(randomString(50));
        System.out.println(randomEmail(20));
        System.out.println(randomNumber(100000L, 9999999L));
        System.out.println(randomPhone("+7916", 1000000L, 9999999L));

        String [] names = {"Chemistry", "Maths", "Reading"};
        System.out.println(randomListItem(names));

        /*int length = 10;
        boolean useLetters = true;
        boolean useNumbers = false;*/


        String generatedString = RandomStringUtils.random(7, false, true);
        System.out.println(generatedString);

        /**
         Крутой способ создания рандомной строки в одну строчку кода
         **/
        String phoneNumber = "+7916" + RandomStringUtils.random(7, false, true);
        System.out.println(phoneNumber);

    }


    public static String randomString(int len) {
        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public static String randomEmail(int len){
        return randomString(len) + "@qa.ru";
    }

    static Long randomNumber(Long min, Long max){
        return ThreadLocalRandom.current().nextLong(min, max);
    }

    static int randomInt(int min, int max){
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    public static String randomPhone(String prefix, Long min, Long max){
        return prefix + randomNumber(min, max);
    }

    public static String randomListItem(String [] values){

        int index = randomInt(0, values.length);
        return values[index];
    }

}
