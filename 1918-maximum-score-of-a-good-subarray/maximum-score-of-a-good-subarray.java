class Solution {

    public int maximumScore(int[] nums, int k) {
        int left = k, right = k;
        int result = nums[k];
        int current_min = nums[k];
        while (left > 0 || right < nums.length - 1) {
              if (left == 0) { // Only expand to the right if left is already at its boundary
                right++;
            } else if (right == nums.length - 1) { // Only expand to the left if right is at its boundary
                left--;
            } else if (nums[left - 1] > nums[right + 1]) {
                left--;
            } else {
                right++;
            }

            current_min = Math.min(current_min, Math.min(nums[left], nums[right]));
            result = Math.max(result, current_min * (right - left + 1));
        }
        return result;
    }
}
