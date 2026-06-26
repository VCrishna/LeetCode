class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {

        int n = nums.length;

        /*
         * Prefix balance:
         *
         *   +1 -> current number == target
         *   -1 -> current number != target
         *
         * Instead of storing negative prefix sums, we shift every value
         * by +n so all indices become non-negative.
         */
        int prefixBalance = n;

        /*
         * freq[x] = number of previous prefixes having balance = x.
         */
        int[] frequency = new int[2 * n + 1];

        // Empty prefix
        frequency[n] = 1;

        /*
         * less = number of valid starting prefixes for the
         * current ending index.
         *
         * ans = total majority subarrays.
         */
        long validPrefixes = 0;
        long majoritySubarrays = 0;

        for (int num : nums) {

            if (num == target) {

                /*
                 * Target contributes +1.
                 *
                 * Every previous prefix having the current balance
                 * now becomes strictly smaller after increasing the
                 * balance, so those prefixes create majority subarrays.
                 */
                validPrefixes += frequency[prefixBalance];
                prefixBalance++;

            } else {

                /*
                 * Non-target contributes -1.
                 *
                 * Balance decreases, so prefixes at the new balance
                 * are no longer valid and must be removed.
                 */
                prefixBalance--;
                validPrefixes -= frequency[prefixBalance];
            }

            // Record current prefix balance.
            frequency[prefixBalance]++;

            // Every valid starting prefix forms a majority subarray.
            majoritySubarrays += validPrefixes;
        }

        return majoritySubarrays;
    }
}