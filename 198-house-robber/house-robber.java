class Solution {
    public int rob(int[] nums) { 
        int rob1 = 0;
        int rob2 = 0;
        int sum = 0;

        for(int i = 0; i < nums.length; i++) {
            int temp = Math.max(nums[i] + rob2, rob1);
            rob2  = rob1;
            rob1 = temp;
        }

        return rob1;
    }
    public int rob_EXTRA_SPACE(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        
        // base cases for the first two houses
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            // For each house i, calculate the maximum amount that can be robbed:
            // Either by robbing the current house and adding the maximum amount from two houses back (dp[i - 2]),
            // or by skipping the current house and taking the maximum amount from the previous house (dp[i - 1])
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        
        return dp[nums.length - 1];
    }
}
