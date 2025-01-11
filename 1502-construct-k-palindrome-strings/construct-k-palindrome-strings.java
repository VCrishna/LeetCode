class Solution {
    public boolean canConstruct(String s, int k) {
        // If k (number of palindromes needed) is greater than the total number of characters,
        // it's impossible to form k palindromes. Returning false immediately
        if (k > s.length())
            return false;

        // Step 1: Initializing an array to store the frequency of each character
        int[] charFreq = new int[26];
        
        // Step 2: Counting the frequency of each character in the string.
        // For each character in the string, increment the corresponding index in the frequency array.
        for (char ch : s.toCharArray()) {
            charFreq[ch - 'a']++; // 'ch - 'a'' converts the character to its index in the alphabet (0-25).
        }

        // Step 3: Counting the number of characters with odd frequencies.
        // A character with an odd frequency must be placed in the middle of a palindrome,
        // and each such character requires a separate palindrome to accommodate it.
        int odd = 0;
        for (int i = 0; i < charFreq.length; i++) {
            // If the frequency of a character is odd, incrementing the `odd` counter.
            odd += charFreq[i] % 2 != 0 ? 1 : 0;
        }

        // Step 4: Checking if the required number of palindromes (`k`) is at least the number of
        // characters with odd frequencies (`odd`). 
        // If true, return true; otherwise, return false.
        // Explanation: 
        // - To form a valid palindrome, all characters must occur an even number of times,
        //   except for at most one character (which can appear in the middle).
        // - The minimum number of palindromes needed is equal to the number of characters with odd frequencies.
        return k >= odd;
    }
}
