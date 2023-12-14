class Solution {
    /*
        Basically the "pattern" of each row should be the same, by pattern, 
        I mean following:
            001100 and 001100 are the same pattern
            001100 and 110011 (the invert of original) are the same pattern
        Only in above situation, one matrix can be converted to all zero
    */
    public boolean removeOnes(int[][] grid) {
        // Get the first row of the grid
        int[] first = grid[0];

        // Invert the first row to compare with inverted rows
        int[] firstInvert = invert(grid[0]);

        // Iterate through the remaining rows starting from the second row
        for (int i = 1; i < grid.length; i++) {
            // Get the current row
            int[] current = grid[i];

            // Check if the current row is either identical to the first row or its inverted version
            if (!Arrays.equals(current, first) && 
                !(Arrays.equals(current, firstInvert))) 
                return false;
        }

        // If all rows are either identical or inverted, return true
        return true;
    }

    public int[] invert(int[] arr) {
        // Create a new array with the same length as the input array
        int[] invertedArray = new int[arr.length];

        // Iterate through each element of the array and invert it (replace 0 with 1 and vice versa)
        for (int i = 0; i < arr.length; i++) {
            invertedArray[i] = 1 - arr[i];
        }

        // Return the inverted array
        return invertedArray;
    }
}
