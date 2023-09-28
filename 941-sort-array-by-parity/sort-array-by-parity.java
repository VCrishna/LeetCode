class Solution {
    // Two Pointer Approach
    public int[] sortArrayByParity(int[] nums) {
        // Base case
        if (nums.length <= 1) 
            return nums;
        // left pointer
        int left = 0;
        // right pointer
        int right = nums.length - 1;
        while (left < right) {
            // checking if element at left is odd & element at right is even
            if (nums[left] % 2 != 0 && nums[right] % 2 == 0) {
                // if that condition is satisfied then we are swapping
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
            // checking if element at left index is even,
            // if it is even then we are moving left pointer
            if (nums[left] % 2 == 0) 
                left++;
            // checking if element at right index is odd,
            // if it is odd then we are moving right pointer
            if (nums[right] % 2 != 0) 
                right--;
        }
        return nums;
    }
    // Brute force approach
    public int[] sortArrayByParity_BRUTE_FORCE(int[] nums) {
        if (nums.length <= 1) 
            return nums;
        // index pointer to keep track of indexes in the result array - this is used for insertion
        int index = 0;
        // result array
        int[] result = new int[nums.length];
        // loop for even numbers
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) result[index++] = nums[i];
        }
        // loop for odd numbers
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) result[index++] = nums[i];
        }

        return result;
    }
}
