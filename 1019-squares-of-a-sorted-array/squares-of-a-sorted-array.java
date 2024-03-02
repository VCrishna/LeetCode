class Solution {
    public int[] sortedSquares(int[] nums) {
        // Initializing result array to store sorted squares
        int[] result = new int[nums.length];

        // Initializing left pointer at the start of the array
        int left = 0;
        // Initializing right pointer at the end of the array
        int right = nums.length - 1;

        // Iterating through the array in reverse order to fill result array
        for (int i = nums.length - 1; i >= 0; i--) {
            // Comparing absolute values of elements at left and right pointers
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                // If absolute value at left pointer is greater,
                // square it and store in result
                result[i] = nums[left] * nums[left];
                // Moving left pointer to the right
                left++;
            } else {
                // If absolute value at right pointer is greater or equal,
                // square it and store in result
                result[i] = nums[right] * nums[right];
                // Moving right pointer to the left
                right--;
            }
        }
        // Returning the sorted squares array
        return result;
    }

    public int[] sortedSquares_BRUTE_FORCE(int[] nums) {
        // Initializing an array to store squares of elements
        int[] squareArray = new int[nums.length];
        // Iterating through the array and compute squares
        for (int i = 0; i < nums.length; i++) {
            squareArray[i] = nums[i] * nums[i];
        }
        // Sorting the square array in non-decreasing order
        Arrays.sort(squareArray);
        // Returning the sorted square array
        return squareArray;
    }
}
