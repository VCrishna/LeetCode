class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {

        int n = nums.length;
        int majoritySubarrayCount = 0;

        /*
         * Convert the array into:
         * +1 -> element equals target
         * -1 -> element does not equal target
         *
         * For any subarray:
         *
         * sum = (#target) - (#nonTarget)
         *
         * If sum > 0, then target appears more than all other
         * elements combined, meaning target is the majority element
         * of that subarray.
         */
        int[] transformed = new int[n];

        for (int i = 0; i < n; i++) {
            transformed[i] = (nums[i] == target) ? 1 : -1;
        }

        /*
         * Check every subarray.
         *
         * Running sum over transformed array:
         *   sum > 0  => target is majority
         *   sum <= 0 => target is not majority
         */
        for (int start = 0; start < n; start++) {

            int balance = 0;

            for (int end = start; end < n; end++) {

                balance += transformed[end];

                if (balance > 0) {
                    majoritySubarrayCount++;
                }
            }
        }

        return majoritySubarrayCount;
    }
}