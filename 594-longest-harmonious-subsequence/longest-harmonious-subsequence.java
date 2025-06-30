class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {
            // Shrink the window until the difference is <= 1
            while (nums[right] - nums[left] > 1) {
                left++;
            }

            // If the window is harmonious (diff == 1), update max
            if (nums[right] - nums[left] == 1) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }

        return maxLength;
    }
}
