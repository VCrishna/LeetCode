class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        int result = nums[0];
        int maxProd = 1;
        int minProd = 1;
        for(int num : nums) {
            int temp = num * maxProd;
            maxProd = Math.max(num, Math.max(temp, num * minProd));
            minProd = Math.min(num, Math.min(temp, num * minProd));
            result = Math.max(result, Math.max(minProd, maxProd));
        }

        return result;
    }
}