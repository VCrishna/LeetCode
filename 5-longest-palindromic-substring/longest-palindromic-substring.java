class Solution {

    public String longestPalindrome(String s) {
        String result = ""; // Variable to store the longest palindrome substring
        int resultLength = 0; // Variable to store the length of the longest palindrome substring

        for (int i = 0; i < s.length(); i++) {
            // Odd length palindrome
            int left = i;
            int right = i;

            // Expandinging around the center (i) for odd length palindromes.
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                // If the current palindrome is longer than the previous result, update the result.
                if (right - left + 1 > resultLength) {
                    result = s.substring(left, right + 1);
                    resultLength = right - left + 1;
                }

                // Expanding the palindrome by moving the pointers outward.
                left--;
                right++;
            }

            // Even length palindrome
            left = i;
            right = i + 1;

            // Expanding around the center (i, i+1) for even length palindromes.
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                // If the current palindrome is longer than the previous result, update the result.
                if (right - left + 1 > resultLength) {
                    result = s.substring(left, right + 1);
                    resultLength = right - left + 1;
                }

                // Expanding the palindrome by moving the pointers outward.
                left--;
                right++;
            }
        }

        return result; // Return the longest palindrome substring.
    }
}
