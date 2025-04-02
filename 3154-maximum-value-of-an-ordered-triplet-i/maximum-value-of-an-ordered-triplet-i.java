class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0; // Triplet not possible

        long result = 0;
        int maxLeft = nums[0]; // Track max value on the left

        for (int j = 1; j < n - 1; j++) { // j is the middle element
            if (nums[j] < maxLeft) { // Ensure valid (maxLeft - nums[j]) term
                for (int k = j + 1; k < n; k++) { // k is the right element
                    result = Math.max(result, (long) (maxLeft - nums[j]) * nums[k]);
                }
            }
            maxLeft = Math.max(maxLeft, nums[j]); // Update maxLeft for next iteration
        }

        return result;
    }
}
