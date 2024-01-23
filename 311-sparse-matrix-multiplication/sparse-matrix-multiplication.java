class Solution {
    int m1Rows;
    int m1Columns;
    int m2Rows;
    int m2Columns;
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        m1Rows = mat1.length;
        m1Columns = mat1[0].length;
        m2Rows = mat2.length;
        m2Columns = mat2[0].length;

        int[][] result = new int[m1Rows][m2Columns];
        for(int row = 0; row < m1Rows; row++) {
            for(int column = 0; column < m2Columns; column++) {
                result[row][column] = calculateMul(mat1, mat2, row, column);
            }
        }
        return result;
    }
    public int calculateMul(int[][] mat1, int[][] mat2, int row, int column) {
        int sum = 0;
        for (int i = 0; i < m1Columns; i++) {
            sum += (mat1[row][i] * mat2[i][column]);
        }
        return sum;
    }
}