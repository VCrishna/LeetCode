class Solution {
    public long minOperations(int[][] queries) {
        long ans = 0;

        // Process each query independently
        for (int[] q : queries) {
            int l = q[0], r = q[1]; // query range [l, r]
            
            long S = 0;   // total "steps contribution" from numbers in [l, r]
            int dMax = 0; // maximum steps needed for any number in [l, r]

            // Iterate over possible bit-lengths (1 to 31 because int <= 2^31-1)
            for (int k = 1; k <= 31; k++) {
                long low = 1L << (k - 1); // smallest number with bit-length k
                long high = (1L << k) - 1; // largest number with bit-length k

                // If the current bit-length interval starts beyond r, no need to continue
                if (low > r) break;

                // Overlap between [l, r] and [low, high]
                long a = Math.max((long)l, low);
                long b = Math.min((long)r, high);

                if (a > b) continue; // no overlap for this k

                // Count of numbers in [l, r] with bit-length = k
                long cnt = b - a + 1;

                // Steps needed for numbers of bit-length k
                // Formula: (k+1)/2 → roughly half the bits (integer division rounding up)
                int stepsForK = (k + 1) / 2;

                // Add total contribution to S
                S += cnt * stepsForK;

                // Track the maximum steps among all numbers in [l, r]
                dMax = Math.max(dMax, stepsForK);
            }

            // Now compute the minimum operations required for query [l, r]
            // - dMax = maximum single number requirement
            // - (S+1)/2 = half of the total requirement (since we can "pair" some ops)
            // Take the max of these two to ensure all numbers are covered
            long ops = Math.max((long)dMax, (S + 1) / 2);

            // Add to the answer
            ans += ops;
        }
        return ans;
    }
}
