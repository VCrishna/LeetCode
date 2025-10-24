class Solution {

    // Helper function to check if a number is "beautiful"
    // A number is beautiful if for every digit d in it, 
    // the digit appears exactly d times in the number.
    public boolean solve(int x){
        // Convert number to string for easy digit iteration
        String s = String.valueOf(x);

        // Frequency array to count how many times each digit appears
        int[] vec = new int[10];
        for (char ch : s.toCharArray()) 
            vec[ch - '0']++;

        // Validate the "beautiful" condition
        for (char ch : s.toCharArray()){
            int c = ch - '0';

            // Condition 1️⃣: digit 0 is not allowed (because 0 occurrences make no sense)
            // Condition 2️⃣: digit must appear exactly 'c' times
            if (c == 0 || vec[c] != c) 
                return false;
        }

        // If all digits satisfy the property, number is beautiful
        return true;
    }

    // Main function: find the smallest number > n that is beautiful
    public int nextBeautifulNumber(int n) {
        // Start from the next integer and keep checking
        for (int i = n + 1; ; i++) 
            if (solve(i)) 
                return i;  // Return the first number that passes the test
    }
}
