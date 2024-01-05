class Solution {
    public int coinChange(int[] coins, int amount) {
        // Creating an array dp to store the minimum number of coins needed for each amount
        int[] dp = new int[amount + 1];

        // Initialize the dp array with a value larger than any possible number of coins
        // i.e., amount + 1
        Arrays.fill(dp, amount + 1);

        // Base case: The minimum number of coins needed to make up amount 0 is 0
        dp[0] = 0;

        // Iterate through each amount from 1 to the target amount
        for (int amt = 1; amt <= amount; amt++) {
            // Iterate through each coin denomination
            for (int coin : coins) {
                // Check if using the current coin doesn't exceed the target amount
                if (amt - coin >= 0) {
                    // Update dp[amt] with the minimum number of coins needed
                    dp[amt] = Math.min(dp[amt], 1 + dp[amt - coin]);
                }
            }
        }

        // If dp[amount] is still greater than amount + 1, 
        // it means it wasn't updated, and there's no valid solution
        // else return dp[amount]
        return dp[amount] != amount + 1 ? dp[amount] : -1;
    }
}
