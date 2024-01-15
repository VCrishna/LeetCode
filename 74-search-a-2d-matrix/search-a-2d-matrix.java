class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        // Initializing the search space boundaries
        int left = 0;
        int right = rows * columns - 1;

        // Binary search within the flattened 2D matrix
        while (left <= right) {
            // Calculating the middle index and retrieve the corresponding value
            int middleIndex = right + (left - right) / 2;
            int middleValue = matrix[middleIndex / columns][middleIndex % columns];

            // Checking if the middle value is equal to the target
            if (middleValue == target) 
                return true;
            
            // If the middle value is greater than the target, 
            // narrowing the search to the left
            if (middleValue > target)
                right = middleIndex - 1;
            else 
                // If the middle value is less than the target, 
                // narrowing the search to the right
                left = middleIndex + 1;
        }
        return false;
    }
}
