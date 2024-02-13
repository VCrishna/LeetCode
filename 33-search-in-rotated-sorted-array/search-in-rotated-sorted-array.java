class Solution {
    public int search(int[] nums, int target) {
        // modified binary search to find the pivot
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int midPoint = left + (right - left) / 2;
            if (nums[midPoint] > nums[right]) {
                left = midPoint + 1;
            } else {
                right = midPoint;
            }
        }
        // regular binary search
        int start = left;
        left = 0;
        right = nums.length - 1;
        // Checking whether the target is within the boundaries
        if (target >= nums[start] && target <= nums[right]) {
            left = start;
        } else {
            right = start;
        }
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target)
                return middle;
            else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }
}
// l r
// [4,5,6,7,0,1,2]