class Solution {
    int MOD = (int) 1e9 + 7;
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return helper(n, k, target, dp);
    }
    public int helper(int n, int k, int target, int[][] dp) {
        if(n < 0 || target < 0) {
            return 0;
        }
        if(n == 0 && target == 0) {
            return 1;
        }
        if(dp[n][target] != -1)
            return dp[n][target];
        int totalWays = 0;
        
        for (int i = 1; i <= k; i++) {
            if(i <= target) {
                totalWays = (totalWays + helper(n - 1, k, target - i, dp)) % MOD;
            }
        }

        dp[n][target] = totalWays;
        return totalWays;
    }
}
