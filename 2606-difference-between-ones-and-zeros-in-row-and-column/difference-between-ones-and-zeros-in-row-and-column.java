class Solution {

    public int[][] onesMinusZeros(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int[] onesRow = new int[rows];
        int[] onesColumns = new int[columns];
        int[][] result = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                onesRow[i] += grid[i][j];
                onesColumns[j] += grid[i][j];
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                // result[i][j] = 2 * onesRow[i] + 2 * onesColumns[j] - rows - columns;
                result[i][j] = onesRow[i] + onesColumns[j] - (rows - onesRow[i]) - (columns - onesColumns[j]);
            }
        }

        return result;
    }
}
