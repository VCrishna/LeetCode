class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;

        for (int row = 1; row < rows; row++) {
            grid[row][0] += grid[row - 1][0];
        }

        for (int column = 1; column < columns; column++) {
            grid[0][column] += grid[0][column - 1];
        }

        for (int row = 1; row < rows; row++) {
            for (int column = 1; column < columns; column++) {
                grid[row][column] += Math.min(
                    grid[row - 1][column],
                    grid[row][column - 1]
                );
            }
        }

        return grid[rows - 1][columns - 1];
    }
}
