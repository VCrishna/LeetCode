class Solution {
    public void nextPermutation(int[] nums) {
        // Step 1: Find the rightmost element in the array 
        // that is smaller than its next element
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // Step 2: If such an element is found, find the 
        // smallest element to the right of i that is greater than nums[i]
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }

            // Step 3: Swap the elements at indices i and j
            swap(nums, i, j);
        }

        // Step 4: Reverse the subarray to the right of i to obtain the
        // lexicographically next permutation
        reverse(nums, i + 1);
    }

    // Helper method to swap two elements in the array
    public void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

    // Helper method to reverse a subarray in the array
    public void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start <= end) {
            // Swap elements at indices start and end, then move towards the center
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}

// [1, 1, 5, 4, 1]
// [1, 4, 1, 1, 5]