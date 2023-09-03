class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // Filling first row with 1's
        // for(int i = 0;i<m; i++) {
        //     dp[i][0] = 1;
        // }
        // Filling first column with 1's
        // for(int i = 0;i<n; i++) {
        //     dp[0][i] = 1;
        // }
        // for any cell we are on we can either come from above or from left
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                // instead of writing two separate for loops to fill 
                // first row and column with 1's, I have just added this line
                // this will fill first row and column with 1's also started these loops from 0 i.e., i, j = 0
                // if first row and column were already filled with 1 then these loops should be started from 1
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    // we are just adding how many ways to get to the cell we are on
                    // dp[i][j] --> how many ways to get to the current cell
                    // dp[i - 1][j] --> cell above us
                    // dp[i][j - 1] --> cell to the left of us
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
