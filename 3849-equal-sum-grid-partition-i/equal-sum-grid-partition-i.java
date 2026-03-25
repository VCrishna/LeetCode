class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        // Step 1: Compute total sum of the grid
        long sum = 0;
        for (int[] ele : grid) {
            for (int ele1 : ele) {
                sum += ele1;
            }
        }

        // -------------------------------
        // Step 2: Try horizontal partition
        // -------------------------------
        //
        // Idea:
        // We try to split the grid into:
        //   top part  (rows 0 → i)
        //   bottom part (rows i+1 → end)
        //
        // 'part' keeps sum of top section
        long part = 0;

        for (int i = 0; i < row; i++) {

            // Add entire row i to current partition
            for (int j = 0; j < col; j++) {
                part += grid[i][j];
            }

            // Check if top == bottom
            //
            // top sum = part
            // bottom sum = total - part
            //
            // If equal → valid partition found
            if (sum - part == part) {
                return true;
            }
        }

        // -------------------------------
        // Step 3: Try vertical partition
        // -------------------------------
        //
        // Reset partition sum
        part = 0;

        // Idea:
        // Split grid into:
        //   left part  (cols 0 → i)
        //   right part (cols i+1 → end)
        //
        for (int i = 0; i < col; i++) {

            // Add entire column i to partition
            for (int j = 0; j < row; j++) {
                part += grid[j][i];
            }

            // Check if left == right
            if (sum - part == part) {
                return true;
            }
        }

        // If no valid partition found
        return false;
    }
}