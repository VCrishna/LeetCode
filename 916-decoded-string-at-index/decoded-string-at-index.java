class Solution {
    public String decodeAtIndex(String s, int k) {
        // Initialize a variable to store the length of the decoded string.
        long decodeStringLength = 0;
        
        // Get the length of the input encoded string s.
        int sLength = s.length();
        
        // Iterate through each character of the string s to compute the length of the decoded string.
        for (char c : s.toCharArray()) {
            
            // If the current character is a digit, it means the previous sequence is repeated that many times.
            if (Character.isDigit(c)) {
                decodeStringLength *= c - '0';  // Multiply the length by the number denoted by the character.
            } else {
                decodeStringLength++;  // If it's a letter, just increment the length by 1.
            }
        }

        // Work backward in the encoded string to determine which character corresponds to the kth position in the decoded string.
        for (int i = sLength - 1; i >= 0; i--) {
            // Fetch the current character at index i.
            char ch = s.charAt(i);
            
            // Adjust k based on the current segment size.
            k %= decodeStringLength; // Important step to adjust k based on repeated sequences

            // If k is 0 and the character is a letter, then this is our target character in the decoded string.
            if (k == 0 && Character.isLetter(ch)) {
                return Character.toString(ch);  // Return the target character as a string.
            }

            // If the current character is a digit, it means the previous segment was repeated.
            if(Character.isDigit(ch)) {
                decodeStringLength /= ch - '0';  // Adjust the length by dividing it by the number denoted by the character.
            }
            else {
                decodeStringLength--;  // If it's a letter, decrease the length by 1.
            }
        }
        
        // This line should never be reached if input is valid.
        return null;
    }
}
