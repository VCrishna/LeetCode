class Solution {
    public boolean isHappy(int n) {
        // Set to keep track of seen sums
        Set<Integer> seen = new HashSet<>();

        // Repeat until n becomes 1 (happy) or enters a cycle (not happy)
        while (n != 1) {
            // Store the current number for checking cycles
            int current = n;
            int sum = 0;

            // Calculate the sum of the squares of each digit in the current number
            while (current > 0) {
                sum += (current % 10) * (current % 10);
                current /= 10;
            }

            // If the sum is already seen, it indicates a cycle,
            // and the number is not happy
            if (seen.contains(sum)) {
                return false;
            }
            // Add the sum to the set of seen sums
            seen.add(sum);
            // Update n with the calculated sum for the next iteration
            n = sum;
        }

        return true; // The number is happy as it reached 1
    }
}
