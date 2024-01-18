class Solution {
    public int characterReplacement(String s, int k) {
        // Array to store the frequency of each character ('A' to 'Z').
        int[] charFrequencies = new int[26];

        // Variables to maintain the sliding window and track the maximum length.
        int windowStart = 0; // Start of the current window.
        int maxLength = 0; // Maximum length of substring with repeating characters.
        int maxCount = 0; // Count of the most frequent character in the current window.

        // Loop through the string using a sliding window approach.
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            // Update the frequency of the current character in the window.
            charFrequencies[s.charAt(windowEnd) - 'A']++;
            int currentCharacterCount = charFrequencies[s.charAt(windowEnd) - 'A'];

            // Update the maximum count of a character in the current window.
            maxCount = Math.max(maxCount, currentCharacterCount);

            // Check if the window size can be expanded 
            // while maintaining at most 'k' replacements.
            while (windowEnd - windowStart - maxCount + 1 > k) {
                // Shrink the window by moving the windowStart and update frequency.
                charFrequencies[s.charAt(windowStart) - 'A']--;
                windowStart++;
            }

            // Update the maximum length of the substring with repeating characters.
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }
}
