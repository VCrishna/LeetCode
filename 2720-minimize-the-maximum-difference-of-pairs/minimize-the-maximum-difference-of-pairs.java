class Solution {

    public int minimizeMax(int[] nums, int p) {
        // Edge case
        if (p == 0)
            return 0;
        // sorting the array
        // sorting is the crux of this problem
        // reason for sorting is that we get minimum difference from adjacent 
        // elements that from other elements present in the array
        Arrays.sort(nums);
        // left and right pointers are used for binary search
        // right pointer stores the difference between first and last element
        // that is the max difference we can obtain from the given array
        // left pointer holds 0
        int left = 0;
        int right = nums[nums.length - 1] - nums[0];
        // result variable is first initialized to right as it is the 
        // maximum diffrence which can be obtained from the given array
        int result = right;
        // Modified binary search
        while (left <= right) {
            // threshold or minimum difference
            // this is equivalent to left + right / 2
            int threshold = left + (right - left) / 2; // avoids integer overflow
            //  if isValid method returns true then we found a new min difference
            if (isValid(nums, p, threshold)) {
                // we update the result variable and move right pointer to middle - 1
                result = threshold;
                right = threshold - 1;
            } else {
                // else we move left pointer to middle + 1
                left = threshold + 1;
            }
        }
        return result;
    }

    // Greedy
    public boolean isValid(int[] nums, int p, int threshold) {
        int count = 0;
        int index = 1;
        while (index < nums.length) {
            // checking if the difference of current and previous elements are 
            // less than threshold or min difference
            // then we increase count and increase index by 2 so the we will not use this index again
            if (nums[index] - nums[index - 1] <= threshold) {
                count++;
                index += 2;
            }
            // if difference is greater then we shift by 1 we only avoid previous elememt and use next element
            else {
                index++;
            }
            // any where in this loop if count is equal to p then we return true
            if (count == p)
                return true;
        }
        return false;
    }
}