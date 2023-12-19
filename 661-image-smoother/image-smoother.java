class Solution {
    public int[][] imageSmoother(int[][] img) {
        int rows = img.length;
        int columns = img[0].length;
        int[][] result = new int[rows][columns];

        for(int row = 0; row < rows; row++) {
            for(int column = 0; column < columns; column++) {
                int total = 0;
                int count = 0;
                // row - 1
                // row
                // row + 1
                for(int i = row - 1; i < row + 2; i++) {
                    for(int j = column - 1; j < column + 2; j++) {
                        if(i < 0 || i == rows || j < 0 || j == columns)
                            continue;
                        total += img[i][j];
                        count++;
                    }
                }

                result[row][column] = (int)Math.floor(total / count);
            }
        }
        

        return result;
    }
}