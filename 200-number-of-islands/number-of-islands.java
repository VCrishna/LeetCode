class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int result = 0;
        for(int row = 0; row < rows; row++) {
            for(int column = 0; column < columns; column++) {
                if(grid[row][column] == '1') {
                    dfs(grid, row, column, rows, columns);
                    result++;
                }
            }
        }
        return result;
    }
    public void dfs(char[][] grid, int row, int column, int rows, int columns) {
        if(
            row < 0 || row >= rows ||
            column < 0 || column >= columns ||
            grid[row][column] != '1'
        ) {
            return;
        }
        grid[row][column] = '0';
        dfs(grid, row + 1, column, rows, columns);
        dfs(grid, row - 1, column, rows, columns);
        dfs(grid, row, column + 1, rows, columns);
        dfs(grid, row, column - 1, rows, columns);
    }
}