class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;

        // Try all 4 possible rotations: 0°, 90°, 180°, 270°
        for (int rot = 0; rot < 4; rot++) {

            // Check if current matrix matches target
            // Intuition: If at any rotation the matrices match → answer is true
            if (is_same(mat, target)) {
                return true;
            }

            // Rotate matrix by 90 degrees clockwise for next iteration
            // Intuition: Instead of manually checking all rotations,
            // just keep rotating and reusing the same comparison logic
            mat = rotate90(mat);
        }

        // If none of the rotations matched
        return false;
    }

    private boolean is_same(int[][] a, int[][] b) {
        int n = a.length;

        // Compare every cell of both matrices
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                // If any element differs → matrices are not equal
                if (a[i][j] != b[i][j]) {
                    return false;
                }
            }
        }

        // All elements matched → matrices are identical
        return true;
    }

    private int[][] rotate90(int[][] mat) {
        int n = mat.length;
        int[][] rotated = new int[n][n];

        // Core rotation logic:
        // Element at (i, j) in original matrix goes to (j, n-1-i) in rotated matrix
        //
        // Intuition:
        // - Row becomes column
        // - Column index is reversed
        //
        // Example:
        // [1 2 3]        [7 4 1]
        // [4 5 6]  -->   [8 5 2]
        // [7 8 9]        [9 6 3]
        //
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                rotated[j][n - 1 - i] = mat[i][j];
            }
        }

        return rotated;
    }
}