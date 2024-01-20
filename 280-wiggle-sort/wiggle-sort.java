class Solution {
    public void wiggleSort(int[] nums) {
        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // Checking if the current index is odd and the 
            // current value is less than the previous value
            if (i % 2 == 1 && nums[i] < nums[i - 1]) {
                // Swapping the current value with the previous value 
                // to ensure values at odd indices are greater
                int temp = nums[i];
                nums[i] = nums[i - 1];
                nums[i - 1] = temp;
            }
            // Checking if the current index is even and the 
            // current value is greater than the previous value
            if (i % 2 == 0 && nums[i] > nums[i - 1]) {
                // Swapping the current value with the previous value 
                // to ensure values at even indices are smaller
                int temp = nums[i];
                nums[i] = nums[i - 1];
                nums[i - 1] = temp;
            }
        }
    }
}
