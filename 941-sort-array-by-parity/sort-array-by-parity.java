class Solution {
    public int[] sortArrayByParity(int[] nums) {
        if (nums.length <= 1) return nums;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] % 2 != 0 && nums[right] % 2 == 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
            if (nums[left] % 2 == 0) left++;
            if (nums[right] % 2 != 0) right--;
        }

        return nums;
    }

    public int[] sortArrayByParity_BRUTE_FORCE(int[] nums) {
        if (nums.length <= 1) return nums;
        int index = 0;
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) result[index++] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) result[index++] = nums[i];
        }

        return result;
    }
}
