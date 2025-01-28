class Solution {
    /**
     * Find the largest sum of connected cells in a grid where movement is allowed
     * to adjacent (up/down/left/right) cells.
     * 
     * When to Use BFS vs DFS vs DSU
     * Algorithm - Use Case - Pros - Cons
     * DFS Small grids, connected components, simple sum Easy to code recursively,
     * minimal code Stack overflow risk for large grids
     * BFS Large grids, shortest path problems Avoids stack overflow, level-order
     * traversal Slightly more code for queue management
     * DSU Dynamic connectivity, grouping cells Efficient for merging sets Harder to
     * track sums, overkill for simple sums
     * Why DFS Here?
     * 
     * Grid size is small (≤10x10).
     * Directly sum values during traversal.
     * Minimal code (4-6 lines for DFS).
     * 
     */
    
    // Helper method to perform Depth-First Search (DFS) from cell (i, j)
    private int solve(int i, int j, int m, int n, int[][] grid, boolean[][] visited) {
        // Base case: if the current position is out of bounds, already visited, or the cell value is 0 (indicating no fish), return 0
        if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j] || grid[i][j] == 0) {
            return 0;
        }
        
        // Marking the current cell as visited
        visited[i][j] = true;
        
        // Initializing the total sum with the value of the current cell
        int total = grid[i][j];
        
        // Recursively exploring all four possible directions (down, right, left, up) 
        // and accumulating the sum
        total += solve(i + 1, j, m, n, grid, visited); // Down
        total += solve(i, j + 1, m, n, grid, visited); // Right
        total += solve(i, j - 1, m, n, grid, visited); // Left
        total += solve(i - 1, j, m, n, grid, visited); // Up
        
        // Returning the total sum of the connected component
        return total;
    }
    
    public int findMaxFish(int[][] grid) {
        int m = grid.length;    // Number of rows in the grid
        int n = grid[0].length; // Number of columns in the grid
        int max = 0;            // Variable to keep track of the maximum sum found
        boolean[][] visited = new boolean[m][n]; // 2D array to track visited cells
        
        // Iterating through each cell in the grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If the cell has not been visited and contains a positive value (indicating presence of fish)
                if (!visited[i][j] && grid[i][j] > 0) {
                    // Performing DFS from this cell and update the maximum sum if a larger sum is found
                    max = Math.max(max, solve(i, j, m, n, grid, visited));
                }
            }
        }
        
        // Returning the maximum sum of connected cells found in the grid
        return max;
    }
}
