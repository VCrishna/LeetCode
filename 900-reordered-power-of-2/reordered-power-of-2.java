class Solution {
    public boolean reorderedPowerOf2(int n) {
        // STEP 1: Precompute signatures of all powers of 2 up to 1e9
        Set<Long> two = new HashSet<>();

        // Loop over all powers of 2 up to ~1 billion
        // (1 << k) will overflow after k > 30, so limit is fine
        for (int i = 1; i <= (int) 1e9; i <<= 1) {
            // Store the digit "signature" of each power of 2
            two.add(transform(i));
        }

        // STEP 2: Compare the signature of n with the precomputed set
        return two.contains(transform(n));
    }

    // This function creates a unique signature for a number's digit multiset
    private long transform(int n) {
        long sum = 0;

        // For each digit in n
        while (n > 0) {
            int d = n % 10; // extract last digit
            // Instead of sorting digits (slow), 
            // we use bit shifting to encode the count of each digit.
            // Each digit's count is represented as +1 in its own "bucket".
            // d*3 ensures no overlap because max count of a digit fits in 3 bits.
            sum += 1L << (d * 3);
            n /= 10;
        }

        return sum;
    }
}
