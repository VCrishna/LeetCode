class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        int left = 0;
        int right = rows * columns - 1;

        while(left <= right) {
            int middleIndex = right + (left - right) / 2;
            int middleValue = matrix[middleIndex / columns][middleIndex % columns];
            if(middleValue == target) 
                return true;
            if(middleValue > target) {
                right = middleIndex - 1;
            }
            else {
                left =  middleIndex + 1;
            }
        }
        return false;
    }
}