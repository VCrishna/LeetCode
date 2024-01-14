class Solution {
    public int rob(int[] nums) {
        return Math.max(
                // Rob houses from the first to the second-to-last (excluding the last house)
                // including first house, excluding last house
                robbingHelper(nums, 0, nums.length - 2),
                // Rob houses from the second to the last (excluding the first house)
                // excluding first house, including last house
                robbingHelper(nums, 1, nums.length - 1));
    }

    public int robbingHelper(int[] nums, int start, int end) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // Dynamic programming array to store the maximum amount that can be robbed at
        // each house
        int[] dp = new int[nums.length];

        // Initialization for the first two houses
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);

        for (int i = start + 2; i <= end; i++) {
            // Choose the maximum amount between robbing the current house plus the amount
            // robbed two houses back,
            // or skipping the current house and taking the maximum amount from the previous
            // house
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[end];
    }

    public int robHelper_CONSTANT_SPACE(int[] nums, int start, int end) {
        int rob1 = 0;
        int rob2 = 0;
        for (int i = start; i <= end; i++) {
            int temp = Math.max(rob1 + nums[i], rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }
}