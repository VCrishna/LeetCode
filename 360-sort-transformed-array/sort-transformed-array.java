class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] result = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            result[i] = a * nums[i] * nums[i] + b * nums[i] + c;
        }
        Arrays.sort(result);

        // int left = 0;
        // int right = nums.length - 1;

        // for(int i = nums.length - 1; i >= 0; i--) {
        //     if(Math.abs(nums[left]) > Math.abs(nums[right])) {
        //         result[i] = a * nums[left] * nums[left] + b * nums[left] + c;
        //     }
        //     else {
        //         result[i] = (a * nums[right] * nums[right]) + (b * nums[right]) + c;
        //     }
        // }

        return result;
    }
}