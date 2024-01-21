class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        // Use a map to store the frequency of characters in the current window
        Map<Character, Integer> charFrequency = new HashMap<>();

        int left = 0; // Left pointer of the window
        int maxLen = 0; // Maximum length of the substring
        int distinctCount = 0; // Count of distinct characters in the current window

        // Iterate through the string with the right pointer
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            charFrequency.put(rightChar, charFrequency.getOrDefault(rightChar, 0) + 1);

            // If a new distinct character is added to the window
            if (charFrequency.get(rightChar) == 1) {
                distinctCount++;
            }

            // Shrink the window if the distinct count exceeds 2
            while (distinctCount > 2) {
                char leftChar = s.charAt(left);
                charFrequency.put(leftChar, charFrequency.get(leftChar) - 1);

                // If the frequency becomes 0, decrement the distinct count
                if (charFrequency.get(leftChar) == 0) {
                    distinctCount--;
                }

                left++; // Move the left pointer to shrink the window
            }

            // Update the maximum length of the substring
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}