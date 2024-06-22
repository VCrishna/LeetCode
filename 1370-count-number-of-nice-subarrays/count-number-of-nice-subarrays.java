class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int result = 0;
        int odd = 0;
        int left = 0;
        int[] count = new int[nums.length + 1];
        count[0] = 1;  // Initialize to handle the case where the subarray starts from the beginning

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] % 2 != 0) {
                odd++;
            }
            if (odd >= k) {
                result += count[odd - k];
            }
            count[odd]++;
        }

        return result;
    }
}
