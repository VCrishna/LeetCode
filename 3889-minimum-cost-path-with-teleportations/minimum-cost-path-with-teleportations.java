class Solution {
    public int minCost(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;

        /*
         dp[i][j][l] = minimum cost to go from cell (i, j)
                       to bottom-right (m-1, n-1)
                       using at most l special operations
        */
        int[][][] dp = new int[m + 1][n + 1][k + 1];

        // Initialize DP with large values (infinity)
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                for (int l = 0; l <= k; l++) {
                    dp[i][j][l] = (int) 1e9;
                }
            }
        }

        /*
         Grid values are assumed to be <= 1e4
         pbest[v] = minimum dp value seen so far
                    among cells whose grid value <= v
        */
        int N = (int) 1e4;
        int[] pbest = new int[N + 1];
        Arrays.fill(pbest, (int) 1e9);

        /*
         Iterate over number of allowed special operations
         This builds DP layer by layer
        */
        for (int l = 0; l <= k; l++) {

            /*
             currbest[v] = minimum dp[i][j][l] for all cells
                           where grid[i][j] == v
            */
            int[] currbest = new int[N + 1];
            Arrays.fill(currbest, (int) 1e9);

            // Traverse grid bottom-up (classic DP order)
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {

                    // Base case: destination cell
                    if (i == m - 1 && j == n - 1) {
                        dp[i][j][l] = 0;
                    }

                    else {
                        int mini = (int) 1e9;

                        // Move down
                        if (i + 1 <= m - 1)
                            mini = Math.min(mini,
                                    grid[i + 1][j] + dp[i + 1][j][l]);

                        // Move right
                        if (j + 1 <= n - 1)
                            mini = Math.min(mini,
                                    grid[i][j + 1] + dp[i][j + 1][l]);

                        /*
                         Special operation:
                         If l > 0, we can "skip" paying cost
                         by connecting to a previously seen cell
                         with grid value <= current grid value
                        */
                        if (l > 0) {
                            mini = Math.min(mini, pbest[grid[i][j]]);
                        }

                        dp[i][j][l] = mini;
                    }

                    // Track best dp value for this grid value
                    currbest[grid[i][j]] =
                        Math.min(currbest[grid[i][j]], dp[i][j][l]);
                }
            }

            /*
             Build prefix minimum array:
             pbest[v] = min(currbest[0..v])
             This allows O(1) lookup for:
             min dp over all grid values <= current value
            */
            pbest = new int[N + 1];
            Arrays.fill(pbest, (int) 1e9);

            pbest[0] = currbest[0];
            for (int i = 1; i <= N; i++) {
                pbest[i] = Math.min(pbest[i - 1], currbest[i]);
            }
        }

        // Answer: min cost from top-left with k operations
        return dp[0][0][k];
    }
}
