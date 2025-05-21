class Solution {
    public void setZeroes(int[][] matrix) {
        // Total number of rows in the matrix
        int rows = matrix.length;
        // Total number of columns in the matrix
        int columns = matrix[0].length;
        boolean rowZero = false;

        // Finding which rows/colmns need to be set to zero
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (matrix[row][column] == 0) {
                    matrix[0][column] = 0;

                    if (row > 0) {
                        matrix[row][0] = 0;
                    } else {
                        rowZero = true;
                    }
                }
            }
        }

        // Changing 1 to zero based on the first row and column
        // if row (or) column element is zero then we are changing
        // entire row elements and column elements to zero
        for (int row = 1; row < rows; row++) {
            for (int column = 1; column < columns; column++) {
                if (matrix[0][column] == 0 || matrix[row][0] == 0) {
                    matrix[row][column] = 0;
                }
            }
        }

        // if first element of the matrix is zero then we are changing all the
        // elements in that row to zero
        if (matrix[0][0] == 0) {
            for (int row = 0; row < rows; row++) {
                matrix[row][0] = 0;
            }
        }

        // if rowZero is true then we are changing all the column elements to zero
        if (rowZero) {
            for (int column = 0; column < columns; column++) {
                matrix[0][column] = 0;
            }
        }
    }
}