class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] result = new int[nums.length];
        int totalSum = 0;
        // calculating total sum of elements in nums
        for (int num : nums) totalSum += num;
        
        int leftSum = 0;

        for (int i = 0; i < nums.length; i++) {
            // Calculating right sum by substracting totalSum, current element 
            // and leftSum(sum of elements left to current element)    
            int rightSum = totalSum - nums[i] - leftSum;
            // calculating sum of absolute difference of current element
            result[i] = (
                // all the elements to the left of current element are smaller
                // current element should be remove from all the elements present on the left side
                // so nums[i] * i (i is the count or total number of elemnts occured so far)
                // and this is subtracted from leftSum
                nums[i] * i - leftSum + 
                // all the elements to the right of the current element are greater
                // so rightSum - (number of elements present to the right side of the current element) * nums[i]
                // nums[i] this should be removed from all the elements present to the right of current element
                rightSum - (nums.length - i - 1) * nums[i]
            );
            leftSum += nums[i];
        }

        return result;
    }
    public int[] getSumAbsoluteDifferences_BRUTE_FORCE(int[] nums) {
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                result[i] += Math.abs(nums[i]-nums[j]);
            }
        }

        return result;
    }
}
