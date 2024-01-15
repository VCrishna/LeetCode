class Solution {
    public int maxSubArray(int[] nums) {
        // Variable for finding max sum of any subarray in given array
        int maxSum = nums[0];
        // variable used to store current sum
        int currentSum = maxSum;
        // As we have intializes maxSum with first element of array,
        // so start from second element
        for (int i = 1; i < nums.length; i++) {
            // Checking if we need to add new element to currentSum
            // or the new element is greater than the currentSum
            // if new element is greater than the current sum then
            // directly updating current sum with new element else
            // we are adding new element to the current sum and updating current sum
            currentSum = Math.max(nums[i], nums[i] + currentSum);
            // finding which value is greater maxSum or current sum and
            // updating max sum with greater value
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}