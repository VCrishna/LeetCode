class Solution {

    public int lengthOfLIS(int[] nums) {
        int max = 1; // Variable to store the maximum length of the LIS
        // Array to store the length of the LIS ending at each index
        int[] dpLIS = new int[nums.length];
        // Initialize dpLIS with 1, as the minimum length of 
        // any LIS is 1 (including the element itself)
        Arrays.fill(dpLIS, 1);

        // Iterating through the array in reverse order to fill dpLIS
        for (int i = nums.length - 1; i >= 0; i--) {
            // Comparing the current element with elements to its right
            for (int j = i + 1; j < nums.length; j++) {
                // If the current element is less than the element to its right, update dpLIS[i]
                if (nums[i] < nums[j]) {
                    dpLIS[i] = Math.max(dpLIS[i], 1 + dpLIS[j]);
                    // Update the maximum length of the LIS
                    max = Math.max(max, dpLIS[i]);
                }
            }
        }

        return max; // Return the maximum length of the LIS
    }
}
