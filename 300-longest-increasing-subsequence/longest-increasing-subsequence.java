class Solution {
    public int lengthOfLIS(int[] nums) {
        int max = 1;
        int[] dpLIS = new int[nums.length];
        Arrays.fill(dpLIS, 1);
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    dpLIS[i] = Math.max(dpLIS[i], 1 + dpLIS[j]);
                    max = Math.max(max, dpLIS[i]);
                }
            }
        }
        return max;
    }
}
