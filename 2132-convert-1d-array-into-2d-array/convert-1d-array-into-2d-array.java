class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        // Base case: If the length of given original array is not 
        // equal to the length of 2D array or m * n then we return empty array
        if(original.length != m * n)
            return new int[0][0];
        int[][] result = new int[m][n];
        for(int i = 0; i < original.length; i++) {
            result[i/n][i%n] = original[i];
        }
        return result;
    }
}

// Brute Force
// public int[][] construct2DArray(int[] original, int m, int n) {
//     // Base case: If the length of given original array is not 
//     // equal to the length of 2D array or m * n then we return empty array
//     if(original.length != m * n)
//         return new int[0][0];
//     // index is used to keep track of position in original array
//     int index = 0;
//     int[][] result = new int[m][n];
//     for(int i = 0; i < m; i++) {
//         // for each i (i.e., new row)
//         int[] row = new int[n];
//         // adding n elements into the row
//         for(int j = 0; j < n; j++) {
//             row[j] = original[index++];
//         }
//         // adding newly created row into our 2D matrix
//         result[i] = row;
//     }
//     return result;
// }