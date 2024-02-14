class Solution {
    public int maxProduct(int[] nums) {
        // If the array has only one element, return that element
        if (nums.length == 1)
            return nums[0];

        // Initialize result to the first element in the array
        int result = nums[0]; // Set result to the first element for handling negative numbers

        // Initialize maxProd and minProd to 1
        int maxProd = 1;
        int minProd = 1;

        for (int num : nums) {
            // Calculate the temporary product by multiplying the current element with
            // maxProd
            // so the we do not lose maxProd value while calculating minProd as we are going
            // to update it before
            int temp = num * maxProd;

            // updating maxProd to be the maximum of the current element, temp (product of
            // the current element and maxProd),
            // and the product of the current element and minProd
            maxProd = Math.max(num, Math.max(temp, num * minProd));

            // updating minProd to be the minimum of the current element, temp (product of
            // the current element and maxProd),
            // and the product of the current element and minProd
            minProd = Math.min(num, Math.min(temp, num * minProd));

            // updating the result to be the maximum of result, minProd, and maxProd
            result = Math.max(result, Math.max(minProd, maxProd));
        }
        return result;
    }
}
