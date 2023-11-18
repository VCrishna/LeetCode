class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = 0;
        int result = 0;
        long total = 0;

        while (right < nums.length) {
            total += nums[right];

            while(nums[right] * (right - left + 1) > total + k) {
                total -= nums[left++];
            }
            // Check if the difference between max and min values in the window is <= k
            result = Math.max(result, right - left + 1);
            if (nums[right] * (right - left + 1) <= total + k) {
                result = Math.max(result, right - left + 1);
            }
            right++;
        }
        return result;
    }
}