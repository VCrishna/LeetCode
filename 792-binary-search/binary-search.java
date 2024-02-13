class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middleIndex = left + (right - left) / 2;
            if (nums[middleIndex] == target)
                return middleIndex;
            if (nums[middleIndex] < target) {
                left = middleIndex + 1;
            } else {
                right = middleIndex - 1;
            }
        }
        return -1;
    }
}