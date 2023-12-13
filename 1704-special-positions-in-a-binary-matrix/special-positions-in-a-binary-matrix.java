class Solution {
    // numSpecial method counts and returns the number of special elements in the matrix
    public int numSpecial(int[][] mat) {
        // result variable to store the count of special elements
        int result = 0;

        // iterate through each element in the matrix
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                // if the element is 1 and it's a special element, increment the count
                if (mat[i][j] == 1 && checkSpecial(mat, i, j)) result++;
            }
        }

        // return the final count of special elements
        return result;
    }

    // checkSpecial method determines if a specific element is special
    public boolean checkSpecial(int[][] mat, int row, int column) {
        // Check the entire row of the given element
        // fixed row, variable column
        for (int i = 0; i < mat[row].length; i++) {
            // If there is another non-zero element in the row (excluding the current column), it's not special
            if (mat[row][i] != 0 && column != i) return false;
        }

        // Check the entire column of the given element
        // variable row, fixed column
        for (int i = 0; i < mat.length; i++) {
            // If there is another non-zero element in the column (excluding the current row), it's not special
            if (mat[i][column] != 0 && row != i) return false;
        }

        // If both row and column checks pass, the element is special
        return true;
    }
}
