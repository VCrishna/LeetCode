class Solution {
    public int longestSubarray(int[] nums) {
        int size = 0;
        int zeroCount = 0;
        int left = 0;

        for(int right = 0; right < nums.length; right++) {
            zeroCount += nums[right] == 0 ? 1 : 0;

            while (zeroCount > 1){
                zeroCount -= nums[left++] == 0 ? 1 : 0;
            }
            size = Math.max(size, right - left);
        }

        return size;
    }
}