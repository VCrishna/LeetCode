class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for(int row = 0; row < dp.length; row++) {
            for(int column = 0; column < dp[row].length; column++) {
                if(row == 0 || column == 0) {
                    dp[row][column] = 1;
                }
                else {
                    dp[row][column] = dp[row - 1][column] + dp[row][column - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}