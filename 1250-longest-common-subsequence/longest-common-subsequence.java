class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        // Create a 2D array to store the length of the longest common subsequence
        int[][] dp = new int[m + 1][n + 1];

        // Fill the dp array using dynamic programming
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // Characters match, extend the common subsequence
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // Characters don't match, choose the maximum length from the previous subproblems
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // The bottom-right cell of the dp array contains the length of the longest common subsequence
        return dp[m][n];
    }
}
