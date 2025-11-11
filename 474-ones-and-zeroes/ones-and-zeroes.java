class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        // dp[i][j] = maximum number of strings we can form
        // using at most i zeros and j ones.
        int[][] dp = new int[m + 1][n + 1];

        // Step 1: Iterate over each string
        for (String s : strs) {
            // Count zeros and ones in the current string
            int[] count = oneZeroCounter(s);
            int zeros = count[0], ones = count[1];

            // Step 2: Traverse DP table backwards
            // Why backwards? → To avoid reusing the same string multiple times.
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    // Step 3: DP Transition
                    // Either:
                    //   - skip current string → dp[i][j]
                    //   - take current string → dp[i - zeros][j - ones] + 1
                    dp[i][j] = Math.max(
                        dp[i][j], 
                        dp[i - zeros][j - ones] + 1
                    );
                }
            }
        }

        // Step 4: Result is the maximum count using full capacity
        return dp[m][n];
    }

    // Helper function to count zeros and ones in a string
    int[] oneZeroCounter(String s) {
        int[] count = new int[2]; // [zeros, ones]
        for (char c : s.toCharArray()) {
            count[c - '0']++;
        }
        return count;
    }
}
