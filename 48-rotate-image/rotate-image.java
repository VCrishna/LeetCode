class Solution {
    public void rotate(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        for (int row = 0; row < rows; row++) {
            for (int column = row; column < rows; column++) {
                int temp = matrix[row][column];
                matrix[row][column] = matrix[column][row];
                matrix[column][row] = temp;
            }
        }
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < rows / 2; column++) {
                int temp = matrix[row][column];
                matrix[row][column] = matrix[row][rows - 1 - column];
                matrix[row][rows - 1 - column] = temp;
            }
        }
    }
}
// class Solution {
//     public void rotate(int[][] matrix) {
//         if(matrix.length == 0 || matrix.length != matrix[0].length)
//             return;
//         int rows=matrix.length;
//         for(int layer=0;layer<rows/2; layer++){
//             int first=layer;
//             int last = rows - 1 - layer;
//             for(int i=first;i<last;i++){
//                 int temp = i-first;
//                 int top=matrix[first][i];
//                 matrix[first][i] = matrix[last - temp][first];
//                 matrix[last - temp][first] = matrix[last][last - temp];
//                 matrix[last][last - temp] = matrix[i][last];
//                 matrix[i][last]=top;
//             }
//         }
//     }
// }
