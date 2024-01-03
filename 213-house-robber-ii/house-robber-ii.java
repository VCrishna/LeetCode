class Solution {
    public int rob(int[] nums) {
        return Math.max(
            // including first house, excluding last house
            robbingHelper(nums, 0, nums.length - 2),
            // excluding first house, including last house
            robbingHelper(nums, 1, nums.length - 1)
        );
    }
    public int robbingHelper(int[] nums, int start, int end) {
        if(nums.length == 0 || nums == null) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        if(nums.length == 2) {
            return Math.max(
                nums[0], nums[1]
            );
        }
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        for(int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[end];
    }
}

/**

    dp[start] = nums[start];
    dp[start + 1] = Math.max(nums[start], nums[start + 1]);

    for (int i = start + 2; i <= end; i++) {
        // Calculate the maximum amount that can be robbed at the current house.
        dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
    }

    // Return the maximum amount that can be robbed from the specified range of houses.
    return dp[end];
 */