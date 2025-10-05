class Solution {
    private int m, n;
    // Possible directions: down, up, right, left
    private int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;    // number of rows
        n = heights[0].length; // number of columns

        // Two visited matrices — one for each ocean
        // pacific[i][j] = true → cell can flow to Pacific Ocean
        // atlantic[i][j] = true → cell can flow to Atlantic Ocean
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // Step 1: DFS from all cells adjacent to Pacific Ocean
        // Pacific touches the top row (0, j) and left column (i, 0)
        for (int j = 0; j < n; j++) dfs(0, j, heights, pacific);  // top edge
        for (int i = 0; i < m; i++) dfs(i, 0, heights, pacific);  // left edge

        // Step 2: DFS from all cells adjacent to Atlantic Ocean
        // Atlantic touches the bottom row (m-1, j) and right column (i, n-1)
        for (int j = 0; j < n; j++) dfs(m - 1, j, heights, atlantic); // bottom edge
        for (int i = 0; i < m; i++) dfs(i, n - 1, heights, atlantic); // right edge

        // Step 3: Cells reachable by *both* DFS traversals can flow to both oceans
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    // DFS helper to mark all cells reachable from a given starting point
    private void dfs(int i, int j, int[][] heights, boolean[][] visited) {
        if (visited[i][j]) return; // already processed
        visited[i][j] = true;

        // Explore 4 directions
        for (int[] d : directions) {
            int x = i + d[0], y = j + d[1];
            
            // Skip out-of-bounds cells
            if (x < 0 || x >= m || y < 0 || y >= n) continue;
            
            // Flow *only* from lower to equal/higher cells (reverse thinking)
            // Because we start from ocean edges and move "uphill"
            if (heights[x][y] < heights[i][j]) continue;
            
            // Continue DFS
            dfs(x, y, heights, visited);
        }
    }
}
