class Solution {
    int[][] dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int[] d : dp)
            Arrays.fill(d,-1);
        return dfs(obstacleGrid, 0, 0);
    }
    public int dfs(int[][] grid, int row, int column) {
        // Exit condition
        // row and column index are valid
        if (row < 0 || column < 0 || 
            // IndexOutOfBound - if row or column is equal to the 
            // length of grid's row or column
            // row & column must be greater than 0 and less than size of grid
            row == grid.length || column == grid[0].length ||
            // grid[row][column] == 1 --> Obstacle
            grid[row][column] == 1) {
                return 0;
            }
        // this means we have reached finish point
        if(row == grid.length - 1 && column == grid[0].length - 1) {
            return 1;
        }
        if(dp[row][column] > -1)
            return dp[row][column];
        // calling dfs on right side + calling dfs on down side
        dp[row][column] = dfs(grid, row, column + 1) + dfs(grid, row+ 1, column);
        return dp[row][column];
    }
}