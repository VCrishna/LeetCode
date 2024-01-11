class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int maxArea = 0;
        for(int row = 0; row < rows; row++) {
            for(int column = 0; column < columns; column++) {
                maxArea = Math.max(maxArea, dfs(grid, row, column, rows, columns));
            }
        }
        return maxArea;
    }
    public int dfs(int[][] grid, int row, int column, int rows, int columns) {
        if(
            row < 0 || row >= rows ||
            column < 0 || column >= columns ||
            grid[row][column] == 0
        ) {
            return 0;
        }
        grid[row][column] = 0;
        int count = 1;
        count += dfs(grid, row + 1, column, rows, columns);
        count += dfs(grid, row - 1, column, rows, columns);
        count += dfs(grid, row, column + 1, rows, columns);
        count += dfs(grid, row, column - 1, rows, columns);
        return count;
    }
}