class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        // Getting the number of rows and columns in the matrix
        int rows = matrix.length;
        int columns = matrix[0].length;

        // Pre-processing the matrix by accumulating values in each column
        for (int row = 0; row < rows; row++) {
            for (int column = 1; column < columns; column++) {
                // Accumulating values in each column by adding the previous column's value
                matrix[row][column] += matrix[row][column - 1];
            }
        }

        // Initializing the count of submatrices with sum equal to the target
        int count = 0;

        // Iterating over all possible pairs of columns (c1, c2)
        for (int c1 = 0; c1 < columns; c1++) {
            for (int c2 = c1; c2 < columns; c2++) {
                // Creating a map to store the prefix sums and their frequencies
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1); // Initialize with 0 sum occurring once
                int sum = 0;

                // Iterating over each row to compute the sum of elements in the submatrix
                for (int row = 0; row < rows; row++) {
                    // Computing the sum of elements in the submatrix using pre-processed values
                    sum += matrix[row][c2] - (c1 > 0 ? matrix[row][c1 - 1] : 0);

                    // If the difference between the current sum and the target exists in the map,
                    // adding the frequency of that difference to the count
                    count += map.getOrDefault(sum - target, 0);

                    // Updating the map with the current sum
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }

        // Returning the final count of submatrices with sum equal to the target
        return count;
    }
}
