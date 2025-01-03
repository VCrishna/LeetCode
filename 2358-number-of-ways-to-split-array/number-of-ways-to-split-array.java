class Solution {
    public int waysToSplitArray(int[] nums) {
        int result = 0;
        if (nums.length == 0)
            return result;
        long left = 0;
        long right = 0;
        for (int num : nums) {
            right += num;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            left += nums[i];
            right -= nums[i];
            result += left >= right ? 1 : 0;
        }
        return result;
    }
}