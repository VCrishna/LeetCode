class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;

        // Updating the first column with cumulative sums
        for (int row = 1; row < rows; row++) {
            grid[row][0] += grid[row - 1][0];
        }
        // Updating the first row with cumulative sums
        for (int column = 1; column < columns; column++) {
            grid[0][column] += grid[0][column - 1];
        }
        // Iterating through the grid to calculate cumulative sums and find the minimum path
        for (int row = 1; row < rows; row++) {
            for (int column = 1; column < columns; column++) {
                // Updating the current cell with the minimum cumulative sum from the top or left
                grid[row][column] += Math.min(
                        grid[row - 1][column],
                        grid[row][column - 1]
                );
            }
        }
        // Returning the minimum path sum at the bottom-right corner of the grid
        return grid[rows - 1][columns - 1];
    }
}
