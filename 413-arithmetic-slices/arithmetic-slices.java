class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int[] dp = new int[nums.length];
        if(nums.length < 3) return 0;
        int count = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1; // extend the current arithmetic slice
                count += dp[i]; // add the slices ending at index i to the total count
            }
        }
        return count;
    }
}