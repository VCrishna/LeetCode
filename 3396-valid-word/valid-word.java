public class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        // Rule 1: Must be at least 3 characters
        if (n < 3) {
            return false;
        }
        int vowels = 0;
        int consonants = 0;
        // Check each character in the string
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                // Check if it's a vowel (case-insensitive)
                if ("aeiouAEIOU".indexOf(c) != -1) {
                    vowels++;
                } else {
                    consonants++; // It's a letter but not a vowel → consonant
                }
            } else if (!Character.isDigit(c)) {
                // If it's not a letter and not a digit → invalid character
                return false;
            }
            // If it’s a digit → valid but doesn’t affect vowel/consonant counts
        }
        // Rule 2: Must have at least one vowel and one consonant
        return vowels >= 1 && consonants >= 1;
    }
}
