class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if (arr.length == 0)
            return 0;
        if (arr.length == 1)
            return arr[0];
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int maxVal = arr[i];
            for (int j = 1; j <= k && i - j + 1 >= 0; j++) {
                maxVal = Math.max(maxVal, arr[i - j + 1]);
                dp[i] = Math.max(dp[i], (i - j >= 0 ? dp[i - j] : 0) + maxVal * j);
            }
        }
        return dp[arr.length - 1];
    }
}