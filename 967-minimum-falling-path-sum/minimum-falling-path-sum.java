class Solution {
    public int minFallingPathSum(int[][] matrix) {
        // Initializing the minimum falling path sum to the maximum possible value
        int min = Integer.MAX_VALUE;

        // Creating a 2D array 'dp' to store intermediate results.
        int[][] dp = new int[matrix.length][matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                if (row == 0) {
                    // For the first row, initializing dp[row][column] with the matrix value
                    dp[row][column] = matrix[row][column];
                } else {
                    // For subsequent rows, calculating the minimum falling path sum
                    // Getting the minimum value from the row above (dp[row-1][column])
                    int rowMin = dp[row - 1][column];

                    // If the current column is not the leftmost, consider the left-top element
                    if (column > 0) {
                        rowMin = Math.min(rowMin, dp[row - 1][column - 1]);
                    }

                    // If the current column is not the rightmost, consider the right-top element
                    if (column < matrix[row].length - 1) {
                        rowMin = Math.min(rowMin, dp[row - 1][column + 1]);
                    }

                    // Calculate the falling path sum for the current element
                    dp[row][column] = matrix[row][column] + rowMin;
                }
            }
        }

        // Find the minimum falling path sum from the last row of dp
        if (matrix.length > 0) {
            for (int column = 0; column < matrix[0].length; column++) {
                min = Math.min(min, dp[matrix.length - 1][column]);
            }
        }
        // Return the minimum falling path sum (or 0 if no valid path is found)
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}