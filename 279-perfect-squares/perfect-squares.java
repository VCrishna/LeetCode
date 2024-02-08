class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        Arrays.fill(dp, 1, n + 1, n + 1);
        for (int target = 1; target < n + 1; target++) {
            for (int s = 1; s * s < target + 1; s++) {
                int square = s * s;
                if (target - square < 0) {
                    break;
                }
                dp[target] = Math.min(dp[target], 1 + dp[target - square]);
            }
        }
        return dp[n];
    }
}