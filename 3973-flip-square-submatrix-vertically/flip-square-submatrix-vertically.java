class Solution {

    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {

        int rows = grid.length;
        int cols = grid[0].length;

        /*
            We reverse the submatrix vertically:
            Swap top row with bottom row,
            then move inward.
        */
        for (int offset = 0; offset < k / 2; offset++) {

            int topRow = x + offset;
            int bottomRow = x + k - 1 - offset;

            /*
                Swap entire rows within the submatrix column range
            */
            for (int col = y; col < y + k; col++) {

                int temp = grid[topRow][col];

                grid[topRow][col] = grid[bottomRow][col];

                grid[bottomRow][col] = temp;
            }
        }

        return grid;
    }
}