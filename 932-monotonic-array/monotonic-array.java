class Solution {
    public boolean isMonotonic(int[] nums) {
        if (nums.length == 1) return true;
        boolean increasing = true;
        boolean decreasing = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) increasing = false;

            if (nums[i - 1] < nums[i]) decreasing = false;
        }
        if (!increasing && !decreasing) {
            return false;
        }
        return true;
    }
}
