package com.ismet;

public class PalindromeChecker {
        public boolean isPalindrome(String str) {
            String cleanStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
            String reversedString = "";
            boolean strBool = false;


            for (int i = cleanStr.length() - 1; i >= 0; i--) {
                reversedString = reversedString + cleanStr.charAt(i);
            }
            reversedString = reversedString.toLowerCase();
            System.out.println(reversedString);
            System.out.println(cleanStr);
            if (cleanStr.equals(reversedString)) {
                strBool = true;
            }
            return strBool;
        }
}


