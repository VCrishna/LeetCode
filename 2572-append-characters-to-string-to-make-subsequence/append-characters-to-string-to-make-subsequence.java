class Solution {
    public int appendCharacters(String s, String t) {
        // Initialize pointer for t
        int j = 0;

        // Iterate through the characters in s
        for (int i = 0; i < s.length(); i++) {
            // If the character in s matches the current character in t
            if (s.charAt(i) == t.charAt(j)) {
                // Move to the next character in t
                j++;
            }
            // If we've matched all characters in t, no need to check further
            if (j == t.length()) {
                break;
            }
        }

        // The number of characters to be appended to s to make t a subsequence
        // is the remaining number of characters in t
        return t.length() - j;
    }
}
