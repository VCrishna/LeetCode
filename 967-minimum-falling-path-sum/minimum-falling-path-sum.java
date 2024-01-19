class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        int[][] dp = new int[matrix.length][matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                if (row == 0) {
                    dp[row][column] = matrix[row][column];
                } else {
                    int rowMin = dp[row - 1][column];
                    if (column > 0) {
                        rowMin = Math.min(rowMin, dp[row - 1][column - 1]);
                    }
                    if (column < matrix[row].length - 1) {
                        rowMin = Math.min(rowMin, dp[row - 1][column + 1]);
                    }
                    dp[row][column] = matrix[row][column] + rowMin;
                }
            }
        }
        if (matrix.length > 0) {
            for (int column = 0; column < matrix[0].length; column++) {
                min = Math.min(min, dp[matrix.length - 1][column]);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}