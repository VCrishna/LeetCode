class Solution {
        
    public long maxAlternatingSum(int[] nums) {
        if(nums.length == 1) return nums[0];
        long peak = 0; // Variable to track the sum of elements at peak positions.
        long low = 0; // Variable to track the sum of elements at low positions.
        long ans = 0; // Variable to store the maximum alternating sum.

        for (int i = 0; i < nums.length - 1;) {
            // Find the peak in the sequence.
            while (i < nums.length - 1 && nums[i] <= nums[i + 1]) {
                i++;
            }
            // Found peak, update the peak sum and update the answer.
            peak += nums[i];
            ans = Math.max(ans, peak - low);

            int j = i;
            // Find the low in the sequence.
            while (j < nums.length - 1 && nums[j] >= nums[j + 1]) {
                j++;
            }

            if (i != j) {
                // Found low, update the low sum and move the pointer to the low position.
                low += nums[j];
                i = j;
            }

            // Update the answer with the maximum alternating sum.
            ans = Math.max(ans, peak - low);
        }

        return ans; // Return the final maximum alternating sum.
    }

    public long maxAlternatingSum_NOT_WORKING(int[] nums) {
        int sumEven = 0;
        int sumOdd = 0;
        for(int i = nums.length - 1; i >= 0; i--) {
            int tempEven = Math.max(sumEven, sumOdd + nums[i]);
            int tempOdd = Math.max(sumOdd, sumEven - nums[i]);
            sumEven = tempEven;
            sumOdd = tempOdd;
        }

        return sumEven;
    }
}
// [6,2,1,2,4,5]
