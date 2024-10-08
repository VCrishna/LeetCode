public class Solution {
    // TC O(log^2 n)
    // SC O(1)
    // This method finds the k-th smallest number in lexicographical order within the range [1, n].
    public int findKthNumber(int n, int k) {
        int current = 1;  // We start with the number 1, as the smallest lexicographical number
        k--;  // Since we are dealing with 0-indexing, we decrement k by 1 to adjust for 1-based indexing.
        
        // While we still need to find the k-th number (i.e., k > 0), continue searching.
        while (k > 0) {
            // Calculate how many numbers lie lexicographically between the current prefix and the next prefix.
            int steps = calculateSteps(n, current, current + 1);
            
            // If the number of steps is less than or equal to k, it means that the k-th number isn't in this prefix.
            if (steps <= k) {
                current += 1;  // Move to the next prefix (e.g., from 1 to 2, or 19 to 20)
                k -= steps;    // Reduce k by the number of steps, as we're skipping over all these numbers.
            } else {
                // If the k-th number is within the current prefix, dive deeper into this prefix.
                current *= 10;  // Drill down to the next level by appending a 0 (e.g., from 1 to 10).
                k--;            // Decrement k, as we've found one number (the current prefix itself).
            }
        }
        
        // Return the current value, which will be the k-th smallest number when k reaches 0.
        return current;
    }

    // Helper method to calculate how many numbers exist lexicographically between `curr` and `next`.
    // This method counts how many numbers are between `curr` and `next` with the constraint that the numbers can't exceed `n`.
    private int calculateSteps(int n, long curr, long next) {
        int steps = 0;  // This variable will store the number of steps between `curr` and `next`.
        
        // Keep expanding the range by multiplying `curr` and `next` by 10 (i.e., exploring deeper levels).
        // We continue expanding as long as `curr` is less than or equal to `n`.
        while (curr <= n) {
            // Add the number of numbers between `curr` and the minimum of `next` or `n + 1`.
            // If `next` is greater than `n`, we can only count numbers up to `n`.
            steps += Math.min(n + 1, next) - curr;
            
            // Move to the next level in the tree (e.g., from 1 -> 10 -> 100).
            curr *= 10;
            next *= 10;
        }
        
        return steps;  // Return the total number of steps/numbers in the range.
    }
}