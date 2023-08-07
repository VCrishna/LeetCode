class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        int left = 0;
        int right = rows * columns - 1;
        while(left <= right) {
            int middleIndex = left + (right - left)/2;
            int middleValue = matrix[middleIndex / columns][middleIndex % columns];
            if (target == middleValue)
                return true;
            if (target < middleValue)
                right = middleIndex - 1;
            else
                left = middleIndex + 1;

        }
        return false;
    }
}