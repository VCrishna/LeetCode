class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] result = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < pivot) {
                result[left++] = nums[i];
            }
            if(nums[nums.length - 1 - i] > pivot) {
                result[right--] = nums[nums.length - 1 - i];
            }
        }
        while(left <= right) {
            result[left++] = pivot;
            result[right--] = pivot;
        }
        return result;
    }

    public int[] pivotArray_BRUTE_FORCE(int[] nums, int pivot) {
        int[] result = new int[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < pivot) {
                result[index++] = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == pivot) {
                result[index++] = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > pivot) {
                result[index++] = nums[i];
            }
        }
        return result;
    }
}
