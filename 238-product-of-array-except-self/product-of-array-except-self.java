class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        
        int[] leftProd = new int[length];
        leftProd[0] = 1;
        int[] rightProd = new int[length];
        rightProd[length - 1] = 1;
        int[] result = new int[length];

        for (int i = 1; i < length; i++) {
            leftProd[i] = leftProd[i - 1] * nums[i - 1];
        }

        // for(int i = length - 2; i >= 0; i--) {
        //     rightProd[i] = rightProd[i + 1] * nums[i + 1];
        // }
        // for(int i = 0; i < length; i++) {
        //     result[i] = leftProd[i] * rightProd[i];
        // }
        
        int mul = 1;
        for (int i = length - 1; i >= 0; i--) {
            result[i] = leftProd[i] * mul;
            mul = mul * nums[i];
        }

        return result;
    }
}
