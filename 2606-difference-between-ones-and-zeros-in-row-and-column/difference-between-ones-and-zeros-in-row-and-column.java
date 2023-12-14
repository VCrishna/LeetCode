class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int[][] result = new int[rows][columns];
        
        int[] oneRows = new int[rows];
        int[] oneColumns = new int[columns];

        for(int row = 0; row < rows; row++) {
            for(int column = 0; column < columns; column++) {
                oneRows[row] += grid[row][column];
                oneColumns[column] += grid[row][column];
            }
        }

        for(int row = 0; row < rows; row++) {
            for(int column = 0; column < columns; column++) {
                result[row][column] = oneRows[row] + oneColumns[column] - (rows - oneRows[row]) - (columns - oneColumns[column]);
            }
        }
        

        return result;
    }
}