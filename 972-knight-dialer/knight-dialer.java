class Solution {
    public int knightDialer(int n) {
        // Base case: If n is 1, there are 10 possible starting digits.
        if (n == 1) return 10;

        // Define the modulo value to avoid integer overflow.
        int MOD = (int) 1e9 + 7;
        int result = 0;

        // Define the possible jumps from each digit on the keypad.
        int[][] jumps = { 
            { 4, 6 },
            { 6, 8 }, 
            { 7, 9 }, 
            { 4, 8 }, 
            { 3, 9, 0 }, 
            {}, 
            { 1, 7, 0 }, 
            { 2, 6 }, 
            { 1, 3 }, 
            { 2, 4 } 
        };

        // Initialize the dynamic programming array with all 1's, 
        // representing one way to start on each digit.
        int[] dp = new int[10];
        for (int i = 0; i < 10; i++) {
            dp[i] = 1;
        }

        // Dynamic Programming Loop
        for (int k = 0; k < n - 1; k++) {
            // Create a new array to store the counts for the next iteration.
            int[] nextDp = new int[10];
            // Iterate over each digit on the keypad.
            for (int digit = 0; digit < 10; digit++) {
                // For each possible jump from the current digit, 
                // update the count in the nextDp array.
                for (int jump : jumps[digit]) {
                    nextDp[jump] = (nextDp[jump] + dp[digit]) % MOD;
                }
            }
            // Update the dp array for the next iteration.
            dp = nextDp;
        }

        // Result Calculation: Sum up the counts in the final dp array.
        for (int count : dp) {
            result = (result + count) % MOD;
        }

        // Return the final result.
        return result;
    }
}
