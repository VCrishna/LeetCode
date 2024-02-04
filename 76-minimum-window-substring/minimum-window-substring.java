class Solution {
    public String minWindow(String s, String t) {
        // Base case: if the target string t is empty, return an empty string
        if (t == "") {
            return "";
        }

        // Creating frequency maps to store character frequencies for strings t and s
        Map<Character, Integer> tCharFrequencyMap = new HashMap<>();
        Map<Character, Integer> sCharFrequencyMap = new HashMap<>();

        // Populating the frequency map for string t
        for (char c : t.toCharArray()) {
            tCharFrequencyMap.put(c, tCharFrequencyMap.getOrDefault(c, 0) + 1);
        }

        // Initializing variables to track the count of characters in the current window
        int have = 0; // Characters that are currently in the window
        int need = tCharFrequencyMap.size(); // Total unique characters needed to form the target string
        int[] result = { -1, -1 }; // Storing the indices of the minimum window
        int resultLength = Integer.MAX_VALUE; // Length of the minimum window
        int left = 0; // Left pointer of the sliding window

        // Iterating through the characters of string s using the right pointer
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // Update the frequency map and check if the character is a part of the target
            // string
            if (tCharFrequencyMap.containsKey(c)) {
                sCharFrequencyMap.put(c, sCharFrequencyMap.getOrDefault(c, 0) + 1);
                // Check if the frequency in the current window matches the required frequency
                if (sCharFrequencyMap.get(c).equals(tCharFrequencyMap.get(c))) {
                    have++;
                }
            }

            // Checking if the current window contains all characters from the target string
            while (have == need) {
                // Updating the result if the current window is smaller than the previously
                // recorded minimum window
                if (right - left + 1 < resultLength) {
                    result[0] = left;
                    result[1] = right;
                    resultLength = right - left + 1;
                }

                // Moving the left pointer to shrink the window by one character
                char leftChar = s.charAt(left);
                // popping from the left of our window
                sCharFrequencyMap.put(leftChar, sCharFrequencyMap.getOrDefault(leftChar, 0) - 1);

                // Checking if removing the leftmost character causes the window to no longer
                // contain all required characters
                if (tCharFrequencyMap.containsKey(leftChar) &&
                        sCharFrequencyMap.get(leftChar) < tCharFrequencyMap.get(leftChar)) {
                    have--;
                }

                left++; // Moving the left pointer to the right
            }
        }

        // Returning the minimum window substring if found, 
        // otherwise return an empty string
        return resultLength != Integer.MAX_VALUE ? s.substring(result[0], result[1] + 1) : "";
    }
}
