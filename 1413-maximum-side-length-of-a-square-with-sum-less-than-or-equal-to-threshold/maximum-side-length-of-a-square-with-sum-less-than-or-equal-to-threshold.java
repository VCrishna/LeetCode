class Solution {

    // Checks if there exists at least one k x k square
    // whose sum is <= limit
    private boolean isValid(int[][] pref, int k, int limit) {
        int n = pref.length;
        int m = pref[0].length;

        // Bottom-right corner of the k x k square
        for (int i = k - 1; i < n; i++) {
            for (int j = k - 1; j < m; j++) {

                // Top-left corner of the square
                int x1 = i - k + 1;
                int y1 = j - k + 1;

                // Compute sum of square using prefix sums
                int sum = pref[i][j];

                if (x1 > 0)
                    sum -= pref[x1 - 1][j];
                if (y1 > 0)
                    sum -= pref[i][y1 - 1];
                if (x1 > 0 && y1 > 0)
                    sum += pref[x1 - 1][y1 - 1];

                // If any valid square found, return true
                if (sum <= limit)
                    return true;
            }
        }
        return false;
    }

    public int maxSideLength(int[][] mat, int threshold) {
        int n = mat.length;
        int m = mat[0].length;

        // Prefix sum matrix
        int[][] pref = new int[n][m];

        // Copy original matrix
        for (int i = 0; i < n; i++)
            System.arraycopy(mat[i], 0, pref[i], 0, m);

        // Row-wise prefix sum
        for (int i = 0; i < n; i++)
            for (int j = 1; j < m; j++)
                pref[i][j] += pref[i][j - 1];

        // Column-wise prefix sum
        for (int j = 0; j < m; j++)
            for (int i = 1; i < n; i++)
                pref[i][j] += pref[i - 1][j];

        // Binary search over side length
        int low = 1, high = Math.min(n, m);
        int ans = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            // If a square of size mid is possible
            if (isValid(pref, mid, threshold)) {
                ans = mid; // update answer
                low = mid + 1; // try bigger square
            } else {
                high = mid - 1; // try smaller square
            }
        }

        return ans;
    }
}
