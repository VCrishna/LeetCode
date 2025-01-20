import java.util.HashMap;
import java.util.Map;

class Solution {
    public int firstCompleteIndex(int[] sequence, int[][] matrix) {
        // Getting the dimensions of the matrix
        int numRows = matrix.length; // Number of rows
        int numCols = matrix[0].length; // Number of columns

        // Map to store the position (row, column) of each number in the matrix
        Map<Integer, int[]> numberToPosition = new HashMap<>();

        // Populating the map with the positions of each number in the matrix
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                numberToPosition.put(matrix[row][col], new int[] { row, col });
            }
        }

        // Arrays to track how many elements have been marked in each row and column
        int[] rowMarkCount = new int[numRows]; // Counts marked elements in each row
        int[] colMarkCount = new int[numCols]; // Counts marked elements in each column

        // Iterating through the sequence
        for (int index = 0; index < sequence.length; index++) {
            // Getting the position of the current number in the matrix
            int[] position = numberToPosition.get(sequence[index]);
            int row = position[0];
            int col = position[1];

            // Incrementing the counts for the corresponding row and column
            rowMarkCount[row]++;
            colMarkCount[col]++;

            // Checking if the current row or column is fully marked
            if (rowMarkCount[row] == numCols || colMarkCount[col] == numRows) {
                return index; // Returning the index of the first completed row or column
            }
        }

        // If no row or column is fully marked, 
        // returning the last index (shouldn't reach here in valid cases)
        return sequence.length - 1;
    }
}
