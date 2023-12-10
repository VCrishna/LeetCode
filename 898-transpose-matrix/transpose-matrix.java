class Solution {
    public int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        int[][] result = new int[columns][rows];

        for(int row = 0; row < rows; row++) {
            for(int column = 0; column < columns; column++) {
                result[column][row] = matrix[row][column];
            }
        }
        
        return result;
    }
}