class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        // result holds number of islands
        int result = 0;
        // Iterating through each cell in the grid
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                // If the current cell is part of an island ('1'), 
                // perform DFS to mark the entire island
                if (grid[row][column] == '1') {
                    dfs(grid, row, column, rows, columns);
                    // Incrementing the result as a new island is found
                    result++;
                }
            }
        }
        return result;
    }
    // Depth-First Search (DFS) method to mark the 
    // entire island connected to the given cell
    public void dfs(char[][] grid, int row, int column, int rows, int columns) {
        // Base case: Check if the current cell 
        // is out of bounds or not part of an island
        if (row < 0 || row >= rows ||
                column < 0 || column >= columns ||
                grid[row][column] != '1') {
            return;
        }
        // Marking the current cell as visited by changing '1' to '0'
        grid[row][column] = '0';
        
        // Recursively performing DFS on adjacent cells in all four directions
        dfs(grid, row + 1, column, rows, columns);
        dfs(grid, row - 1, column, rows, columns);
        dfs(grid, row, column + 1, rows, columns);
        dfs(grid, row, column - 1, rows, columns);
    }
}