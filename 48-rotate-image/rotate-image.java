class Solution {
    public void rotate(int[][] matrix) {
        int rows=matrix.length;
        
        for(int i=0;i<rows;i++){ // loop to traverse through rows
            for(int j=i;j<rows;j++){ // loop to traverse through columns
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i=0;i<rows;i++){ // Using two pointer approach to swap columns
            for(int j=0; j < rows/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][rows-1-j];
                matrix[i][rows-1-j] = temp;
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