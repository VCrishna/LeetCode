class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        // Maximum possible side length of a square
        int side = Math.min(m, n);

        // Try larger squares first, then decrease size
        while (side > 0) {
            // Iterate over all possible top-left corners
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {

                    // Ensure square of this size fits inside grid
                    if (i + side <= m && j + side <= n) {

                        // Check if this square is magic
                        if (isValid(grid, m, n, i, j, side)) {
                            return side; // largest found
                        }
                    }
                }
            }
            side--; // Try smaller square
        }

        return 0; // No magic square found
    }

    private boolean isValid(int[][] grid, int m, int n, int i, int j, int side) {
        int sum = 0;

        // ---------- Check all rows ----------
        for (int x = i; x < i + side; x++) {
            int rowSum = 0;
            for (int y = j; y < j + side; y++) {
                rowSum += grid[x][y];
            }

            // First row defines the target sum
            if (x == i) sum = rowSum;
            else if (sum != rowSum) return false;
        }

        // ---------- Check all columns ----------
        for (int x = j; x < j + side; x++) {
            int colSum = 0;
            for (int y = i; y < i + side; y++) {
                colSum += grid[y][x];
            }
            if (sum != colSum) return false;
        }

        // ---------- Check main diagonal ----------
        int diagSum = 0;
        for (int k = 0; k < side; k++) {
            diagSum += grid[i + k][j + k];
        }
        if (sum != diagSum) return false;

        // ---------- Check anti-diagonal ----------
        diagSum = 0;
        for (int k = 0; k < side; k++) {
            diagSum += grid[i + k][j + side - 1 - k];
        }
        if (sum != diagSum) return false;

        // All checks passed → magic square
        return true;
    }
}
