package problem.longestPalindrome;

class Solution {
    public static String longestPalindrome(String s) {
        int maxLen = 0;
        int strLen = s.length();
        String longestPalindrome = "";
        int leftBound, rightBound = 0;
        if (strLen <= 1)
            return s;

        // Iterate over each char, treading it as the middle of a potential palindrome
        for (int i = 0; i < strLen; i++) {
            // Odd length palindromes
            leftBound = i;
            rightBound = i;
            // If leftBound equals rightBound and they are in the string bounds
            while (leftBound >= 0 && rightBound < strLen && s.charAt(leftBound) == s.charAt(rightBound)) {
                if ((rightBound - leftBound) >= maxLen) {
                    longestPalindrome = s.substring(leftBound, rightBound + 1);
                    maxLen = longestPalindrome.length();
                }
                leftBound--;
                rightBound++;
            }

            // Even length palindromes
            leftBound = i;
            rightBound = i + 1; // Rookie mistake using i++ the first time instead of i+1...
            while (leftBound >= 0 && rightBound < strLen && s.charAt(leftBound) == s.charAt(rightBound)) {
                if ((rightBound - leftBound) >= maxLen) {
                    longestPalindrome = s.substring(leftBound, rightBound + 1);
                    maxLen = longestPalindrome.length();
                }
                leftBound--;
                rightBound++;
            }
        }
        return longestPalindrome;
    }
}