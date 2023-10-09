class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        left[0] = 1;
        int[] right = new int[nums.length];
        right[right.length - 1] = 1;
        int[] result = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            left[i] = nums[i - 1] * left[i - 1];
        }
        // for (int i = nums.length - 2; i >= 0; i--) {
        //     right[i] = right[i + 1] * nums[i + 1];
        // }
        // for (int i = 0; i < nums.length; i++) {
        //     result[i] = left[i] * right[i];
        // }
        // without using extra space
        int mul = 1;
        for(int i = nums.length - 1; i>= 0; i--) {
            result[i] = left[i] * mul;
            mul = mul * nums[i];
        }
        return result;
    }
}

