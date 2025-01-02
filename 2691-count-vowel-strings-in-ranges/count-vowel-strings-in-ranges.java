class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] result = new int[queries.length]; // Array to store results for each query.
        int[] cache = new int[words.length + 1]; // Prefix sum array to store cumulative counts of valid strings.

        // Step 1: Building the prefix sum array (cache)
        for (int i = 1; i <= words.length; i++) {
            // Add the cumulative count of valid words up to index `i - 1`
            cache[i] = cache[i - 1] + (isStartEndWithVowel(words[i - 1]) ? 1 : 0);
        }

        // Step 2: Processing each query
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0]; // Start index of the query
            int end = queries[i][1]; // End index of the query

            // Using prefix sum to calculate the count of valid
            // strings in the range [start, end]
            result[i] = cache[end + 1] - cache[start];
        }

        return result; // Returning the results for all queries.
    }

    public boolean isStartEndWithVowel(String s) {
        // List of vowels (both uppercase and lowercase)
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

        // Ensure the string is non-null and has at least one character
        if (s != null && s.length() >= 1) {
            // Check if the first and last characters are vowels
            return vowels.contains(s.charAt(0)) && vowels.contains(s.charAt(s.length() - 1));
        }
        return false; // If string is null or empty, return false.
    }
}
