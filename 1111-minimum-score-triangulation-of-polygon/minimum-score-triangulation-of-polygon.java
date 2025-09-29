class Solution {
    // dp[i][j] = minimum triangulation score between vertices i and j
    private int[][] dp;

    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        dp = new int[n][n]; // initialize memo table with 0s
        return solve(values, 0, n - 1);
    }

    // Recursive helper: computes min triangulation score for polygon slice (i..j)
    private int solve(int[] values, int i, int j) {
        // Base case: fewer than 3 points -> no triangle
        if (j - i < 2) return 0;

        // Return memoized result if available
        if (dp[i][j] != 0) return dp[i][j];

        int res = Integer.MAX_VALUE;

        // Try all possible middle vertices k between (i, j)
        for (int k = i + 1; k < j; k++) {
            // Cost = left part + triangle(i,k,j) + right part
            int cost = solve(values, i, k) +
                       values[i] * values[k] * values[j] +
                       solve(values, k, j);
            res = Math.min(res, cost);
        }

        // Save and return
        dp[i][j] = res;
        return res;
    }
}
