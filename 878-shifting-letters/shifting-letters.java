class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int n = shifts.length;
        long totalShifts = 0; // Using long to avoid overflow with large shifts
        StringBuilder sb = new StringBuilder(s);

        // Calculating total shifts by accumulating from the end of the shifts array
        for (int i = n - 1; i >= 0; i--) {
            totalShifts += shifts[i];
            totalShifts %= 26; // Reducing total shifts to within one alphabet cycle

            // Updating the character in the string
            char ch = s.charAt(i);
            char shiftedChar = (char) (               // Converting the computed integer result back into a character
                                        'a' +         // Starting from 'a' (the base ASCII value of lowercase letters)
                                        (ch - 'a'     // Finding the zero-based position of the current character in the alphabet
                                        + totalShifts // Adding the total shifts to determine the new position in the alphabet
                                        ) % 26        // Using modulo to wrap around the alphabet if the position exceeds 25
                                      );

            sb.setCharAt(i, shiftedChar);
        }

        return sb.toString();
    }
}
