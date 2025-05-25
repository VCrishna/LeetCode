class Solution {
    public int longestPalindrome(String[] words) {
        // Step 1: Count the frequency of each word using a HashMap
        Map<String, Integer> countMap = new HashMap<>();
        for (String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }

        int length = 0;        // Total length of the palindrome
        boolean hasCenter = false; // Flag to indicate if we can use a symmetric word as the center of the palindrome

        // Step 2: Process each word
        for (String word : countMap.keySet()) {
            String reversed = new StringBuilder(word).reverse().toString();

            if (!word.equals(reversed)) {
                // Case 1: Asymmetric word like "ab" and its reverse "ba"
                // We can use as many pairs of ("ab", "ba") as possible
                if (countMap.containsKey(reversed)) {
                    int pairs = Math.min(countMap.get(word), countMap.get(reversed));

                    // Each pair contributes 4 characters (2 from "ab", 2 from "ba")
                    length += pairs * 4;

                    // Decrease counts since we used these words
                    countMap.put(word, countMap.get(word) - pairs);
                    countMap.put(reversed, countMap.get(reversed) - pairs);
                }
            } else {
                // Case 2: Symmetric word like "aa", "cc" (same forwards and backwards)
                int count = countMap.get(word);

                // Every 2 symmetric words can be placed on both sides of the palindrome
                length += (count / 2) * 4;

                // If there's an odd one left, it can potentially be used in the center
                if (count % 2 == 1) {
                    hasCenter = true;
                }

                // We only need to set hasCenter once, since only one symmetric word can be used as the center
            }
        }

        // Step 3: Add 1 symmetric word in the center, if available
        if (hasCenter) {
            length += 2; // Adds the middle symmetric word (e.g., "gg") once
        }

        // Step 4: Return the final computed length
        return length;
    }
}
