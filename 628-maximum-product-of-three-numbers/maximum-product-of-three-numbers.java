class Solution {
    public int maximumProduct(int[] nums) {
        // Initialize variables to track the top three maximum values
        // and the two minimum values
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            // Update top three maximum values
            if (max1 < nums[i]) {
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            } else if (max2 < nums[i]) {
                max3 = max2;
                max2 = nums[i];
            } else if (max3 < nums[i]) {
                max3 = nums[i];
            }

            // Update two minimum values
            if (min1 > nums[i]) {
                min2 = min1;
                min1 = nums[i];
            } else if (min2 > nums[i]) {
                min2 = nums[i];
            }
        }
        return Math.max(max1 * max2 * max3, min1 * min2 * max1);
    }

    public int maximumProduct_SORTING(int[] nums) {
        // Sort the array in ascending order
        Arrays.sort(nums);
        int n = nums.length;

        // Calculate the product of the three largest elements
        int product1 = nums[n - 1] * nums[n - 2] * nums[n - 3];

        // Calculate the product of the two smallest elements and the largest element
        int product2 = nums[0] * nums[1] * nums[n - 1];

        return Math.max(product1, product2);
    }

}
