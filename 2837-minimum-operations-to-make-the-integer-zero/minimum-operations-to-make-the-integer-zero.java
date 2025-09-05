class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        // Try all possible values of k (number of operations).
        // Why up to 60?
        // Because 2^60 > 1e18, which is way beyond any possible difference we need to represent.
        for (int k = 1; k <= 60; k++) {
            
            // x = num1 - num2 * k
            // Interpretation:
            //   After subtracting `k * num2` from num1, we want to check if the remainder (x)
            //   can be represented as a sum of exactly k powers of 2 (since each operation
            //   can reduce x by some 2^p).
            long x = 1L * num1 - 1L * num2 * k;

            // If x is smaller than k, it's impossible:
            //   because the smallest possible sum with k terms is k (all ones).
            if (x < k) {
                return -1;
            }

            // Condition: k >= Long.bitCount(x)
            //   - bitCount(x) = minimum number of powers of 2 needed to represent x in binary.
            //   - If k >= bitCount(x), we can "pad" the representation with extra 1s
            //     (by splitting bigger powers into smaller ones).
            if (k >= Long.bitCount(x)) {
                return k; // Found the smallest valid k
            }
        }

        // If no k worked, return -1
        return -1;
    }
}
