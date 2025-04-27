class Solution {
    public int countSubarrays(int[] nums) {
        int result = 0;
        int left = 0, middle = 1, right = 2;

        while (right < nums.length) {
            if (nums[middle] == (nums[left] + nums[right]) * 2) {
                result++;
            }
            left++;
            middle++;
            right++;
        }

        return result;
    }
}