class Solution {
    public int colorTheGrid(int m, int n) {
        final int mod = 1_000_000_007;

        // total = total number of possible colorings of one column using 3 colors
        // Each cell in a column can be painted in 3 colors => 3^m combinations
        int total = 1;
        for (int i = 0; i < m; i++)
            total *= 3;

        // dp[col][state] = number of ways to color the first `col` columns
        // ending in column pattern `state` (an integer representation of a pattern)
        int[][] dp = new int[n + 1][total];

        // rowValid[i][j] = whether column pattern `j` can come after pattern `i`
        // This ensures adjacent columns don't have the same color in any row
        int[][] rowValid = new int[total][total];

        // good = list of valid column patterns (with no vertical same-color cells)
        List<Integer> good = new ArrayList<>();

        // pattern[i] = the actual base-3 representation (coloring) of column pattern `i`
        List<Integer>[] pattern = new ArrayList[total];
        for (int i = 0; i < total; i++)
            pattern[i] = new ArrayList<>();

        // Step 1: Generate all valid patterns for a single column
        for (int i = 0; i < total; i++) {
            int val = i, valid = 1;

            // Decode pattern `i` as base-3, each digit represents a row's color
            for (int j = 0; j < m; j++) {
                pattern[i].add(val % 3);
                val /= 3;
            }

            // Check if any two adjacent cells in the column have the same color
            for (int j = 1; j < m; j++)
                if (pattern[i].get(j).equals(pattern[i].get(j - 1)))
                    valid = 0;

            // Only add to valid patterns if no vertical color repetitions
            if (valid == 1)
                good.add(i);
        }

        // Step 2: Initialize DP for the first column
        for (int i : good)
            dp[1][i] = 1;

        // Step 3: Build compatibility map between valid patterns
        for (int i : good) {
            for (int j : good) {
                rowValid[i][j] = 1; // Assume compatible

                // If any row has same color between two patterns, mark as incompatible
                for (int k = 0; k < m; k++)
                    if (pattern[i].get(k).equals(pattern[j].get(k)))
                        rowValid[i][j] = 0;
            }
        }

        // Step 4: Use DP to fill grid from column 2 to n
        for (int col = 2; col <= n; col++) {
            for (int i : good) {
                long sum = 0;

                // Sum all valid transitions from previous column to this one
                for (int j : good)
                    if (rowValid[i][j] == 1)
                        sum += dp[col - 1][j];

                // Store the count of ways to reach pattern `i` at column `col`
                dp[col][i] = (int) (sum % mod);
            }
        }

        // Step 5: Sum all ways to color the full grid ending with any valid pattern
        long ans = 0;
        for (int i = 0; i < total; i++)
            ans += dp[n][i];

        return (int) (ans % mod);
    }
}
