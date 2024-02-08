class Solution {
    public int numSquares(int n) {
        // Create an array to store the minimum number of 
        // perfect squares needed to sum up to each index
        int[] dp = new int[n + 1];

        // Initialize dp[0] to 0
        dp[0] = 0;

        // Fill the rest of the array with a value 
        // greater than n to indicate uncalculated values
        Arrays.fill(dp, 1, n + 1, n + 1);

        // Iterate through each target sum from 1 to n
        for (int target = 1; target <= n; target++) {
            // Iterate through each square number from 1 to the current target
            for (int s = 1; s * s <= target; s++) {
                int square = s * s;
                // Update dp[target] with the minimum of its 
                // current value and 1 plus the value at dp[target - square]
                dp[target] = Math.min(dp[target], 1 + dp[target - square]);
            }
        }

        // Return the minimum number of perfect squares needed to sum up to n
        return dp[n];
    }
}
