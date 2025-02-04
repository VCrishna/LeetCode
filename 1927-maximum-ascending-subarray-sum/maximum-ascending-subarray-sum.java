class Solution {
    public int maxAscendingSum(int[] nums) {
        int res = nums[0];          // Stores the maximum sum found
        int currsum = nums[0];      // Tracks the current ascending subarray sum

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                currsum += nums[i];  // Continue adding to current sum if ascending
            } else {
                res = Math.max(res, currsum);  // Update result if current sum is greater
                currsum = nums[i];             // Reset for new sequence
            }
        }

        res = Math.max(res, currsum);  // Final check for the last sequence
        return res;
    }
}