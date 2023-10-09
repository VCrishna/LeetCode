class Solution {

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = firstIndex(nums, target);
        result[1] = lastIndex(nums, target);
        return result;
    }

    public int firstIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int index = -1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] >= target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
            if (nums[middle] == target) {
                index = middle;
            }
        }
        return index;
    }

    public int lastIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int index = -1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                index = middle;
            }
            if (nums[middle] <= target) {
                left = middle + 1;
            }
            else {
                right = middle - 1;
            }
        }
        return index;
    }

    public int[] searchRange_BRUTE_FORCE(int[] nums, int target) {
        int[] result = new int[2];
        Arrays.fill(result, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                result[0] = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == target) {
                result[1] = i;
                break;
            }
        }
        return result;
    }
}
