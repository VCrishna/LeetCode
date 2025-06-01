class Solution {
    public long distributeCandies(int n, int limit) {
        // Inclusion-Exclusion Principle:
        // Total valid combinations = total - over-limit cases + double over-limit - triple over-limit
        return combCount(n)
             - 3 * combCount(n - (limit + 1))            // subtract if any one child exceeds limit
             + 3 * combCount(n - 2 * (limit + 1))        // add back if two children exceed
             - combCount(n - 3 * (limit + 1));           // subtract if all three exceed
    }

    private long combCount(long sum) {
        // This function returns the number of integer solutions to:
        // x + y + z = sum where x, y, z ≥ 0
        // The formula is (sum + 2) choose 2 => (sum + 2) * (sum + 1) / 2
        if (sum < 0) return 0;  // No valid combinations if the total is negative
        return (sum + 2) * (sum + 1) / 2;
    }
}
