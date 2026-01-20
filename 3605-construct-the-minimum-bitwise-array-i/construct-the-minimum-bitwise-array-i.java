class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] res = new int[nums.size()];

        for (int i = 0; i < nums.size(); i++) {
            int n = nums.get(i);

            // If n is even, no valid solution exists
            // Because even numbers end with 0 in binary
            if ((n & 1) == 1) {

                /*
                 * Step-by-step bit intuition:
                 *
                 * Example: n = 13  ->  binary: 1101
                 *
                 * n + 1 = 14        -> 1110
                 * ~n                -> 0010
                 * (n + 1) & ~n      -> 0010   (isolates lowest zero bit)
                 *
                 * >> 1              -> 0001   (bit just before it)
                 *
                 * ~(...)            -> clears that bit in n
                 *
                 * Result: smallest number < n satisfying the constraint
                 */

                // Find lowest zero bit after trailing ones,
                // shift right to get the bit before it,
                // then clear that bit in n
                res[i] = n & ~(((n + 1) & ~n) >> 1);
            } else {
                // Even numbers cannot produce a valid result
                res[i] = -1;
            }
        }

        return res;
    }
}
