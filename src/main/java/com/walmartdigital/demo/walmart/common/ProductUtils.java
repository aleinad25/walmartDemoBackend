package com.walmartdigital.demo.walmart.common;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductUtils {
    public static boolean isPalindrome(String text){
        String rev = (new StringBuilder(text)).reverse().toString();
        return text.equals(rev);
    }
    public static boolean isPalindromeNumber(Integer num){
        int palindrome = num;
        int reverse = 0;

        while (palindrome != 0) {
            int remainder = palindrome % 10;
            reverse = reverse * 10 + remainder;
            palindrome = palindrome / 10;
        }
        return num == reverse;
    }

    public static BigDecimal getSalePrice(BigDecimal price){
        return price.divide(new BigDecimal(2)).setScale(0,BigDecimal.ROUND_HALF_UP);
    }
    public static boolean isNumber(String param){
        try {
            Integer.parseInt(param);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }
}
