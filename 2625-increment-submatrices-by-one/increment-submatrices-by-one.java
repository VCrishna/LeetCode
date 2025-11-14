class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {

        // -------------------------------
        // 1. CREATE A 2D DIFFERENCE MATRIX
        // -------------------------------
        // diff is (n+1) x (n+1) because we will use row2+1 and col2+1 updates
        // for marking rectangle boundaries.
        int[][] diff = new int[n + 1][n + 1];
        
        // ---------------------------------------------------------------
        // 2. APPLY EACH QUERY TO THE DIFFERENCE MATRIX
        // ---------------------------------------------------------------
        // For each query [r1, c1, r2, c2], we want to increment the submatrix:
        // (r1, c1) → (r2, c2) by +1.
        //
        // Using 2D difference array technique:
        // diff[r1][c1] += 1
        // diff[r2+1][c1] -= 1
        // diff[r1][c2+1] -= 1
        // diff[r2+1][c2+1] += 1
        //
        // Later prefix sum reconstructs all increments automatically.
        // ---------------------------------------------------------------
        for (int[] q : queries) {
            int r1 = q[0], c1 = q[1], r2 = q[2], c2 = q[3];

            diff[r1][c1]++;           // start of rectangle
            diff[r2 + 1][c1]--;       // remove effect below rectangle
            diff[r1][c2 + 1]--;       // remove effect to the right
            diff[r2 + 1][c2 + 1]++;   // add back the over-subtracted corner
        }
        
        // ---------------------------------------------
        // 3. BUILD FINAL MATRIX USING 2D PREFIX SUM
        // ---------------------------------------------
        // mat[i][j] = diff[i][j]
        //           + mat[i-1][j]      (from above)
        //           + mat[i][j-1]      (from left)
        //           - mat[i-1][j-1]    (remove double-count)
        //
        // This converts difference array → actual matrix of increments.
        // ---------------------------------------------
        int[][] mat = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                int above = i > 0 ? mat[i - 1][j] : 0;
                int left  = j > 0 ? mat[i][j - 1] : 0;
                int diag  = (i > 0 && j > 0) ? mat[i - 1][j - 1] : 0;

                // diff[i][j] comes from the difference matrix
                mat[i][j] = diff[i][j] + above + left - diag;
            }
        }
        
        return mat;
    }
}
