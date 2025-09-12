class Solution {
    public boolean doesAliceWin(String s) {
        // Loop through every character in the string
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If the character is a vowel (a, e, i, o, u)
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                // Alice wins immediately because the condition is satisfied
                return true;
            }
        }

        // If we finish scanning the string and no vowel was found,
        // then Alice cannot win
        return false;
    }
}
