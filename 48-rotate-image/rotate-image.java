class Solution {

    public void rotate(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        // Transpose Matrix
        for (int row = 0; row < rows; row++) {
            for (int column = row; column < columns; column++) {
                int temp = matrix[row][column];
                matrix[row][column] = matrix[column][row];
                matrix[column][row] = temp;
            }
        }

        // swapping with two pointers
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns / 2; column++) {
                int temp = matrix[row][column];
                matrix[row][column] = matrix[row][columns - column - 1];
                matrix[row][columns - column - 1] = temp;
            }
        }
    }
}
