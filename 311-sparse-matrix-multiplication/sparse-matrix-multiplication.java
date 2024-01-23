class Solution {
    int m1Rows;
    int m1Columns;
    int m2Rows;
    int m2Columns;
    
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        // Setting dimensions of matrices
        m1Rows = mat1.length;
        m1Columns = mat1[0].length;
        m2Rows = mat2.length;
        m2Columns = mat2[0].length;

        // Initializing result matrix with dimensions m1Rows x m2Columns
        int[][] result = new int[m1Rows][m2Columns];

        // the number of columns in the first matrix (mat1) should be 
        // equal to the number of rows in the second matrix (mat2)
        if(m1Columns != m2Rows) {
            return result;
        }

        // Iterating through each row of the first matrix (mat1)
        for (int row = 0; row < m1Rows; row++) {
            // Iterating through each column of the second matrix (mat2)
            for (int column = 0; column < m2Columns; column++) {
                // Calculating the value for the current cell in the result matrix
                result[row][column] = calculateMul(mat1, mat2, row, column);
            }
        }
        return result;
    }

    // Calculating the multiplication of the specified cell in the result matrix
    public int calculateMul(int[][] mat1, int[][] mat2, int row, int column) {
        int sum = 0;
        // Iterating through the corresponding elements in the row of mat1 and column of mat2
        for (int i = 0; i < m1Columns; i++) {
            sum += (mat1[row][i] * mat2[i][column]);
        }
        // Returning the sum, representing the result of the multiplication for the current cell
        return sum;
    }
}
