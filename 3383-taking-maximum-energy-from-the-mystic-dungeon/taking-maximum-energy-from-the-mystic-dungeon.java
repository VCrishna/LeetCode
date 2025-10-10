class Solution {
    /**
     * Finds the maximum total energy collected by starting at any room i and jumping by k.
     * The solution uses a single backward pass to compute the maximum suffix sum for each k-interleaved sequence.
     * Time Complexity: O(N)
     * Space Complexity: O(1) (by modifying the input array)
     */
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        
        // 1. Compute the maximum path sum starting at index i
        // by working backward and adding the result from i + k.
        // The loop starts at n - 1 - k, as this is the first index
        // that can "see" an index k steps ahead (n - 1).
        for (int i = n - 1 - k; i >= 0; i--) {
            energy[i] += energy[i + k];
        }
        
        // 2. The maximum energy must be one of the calculated path sums.
        // These path sums are stored in the modified 'energy' array.
        // We only need to check the values from the first valid starting indices,
        // which are the last k indices: n - k to n - 1. 
        // All paths that start before this have had their total sum propagated 
        // backward into the first k indices (0 to k-1).
        
        int maxEnergy = Integer.MIN_VALUE;
        
        // Check all values that can be a starting point (from index 0 up to n - 1)
        // after the backward DP pass is complete.
        for (int i = 0; i < n; i++) {
            maxEnergy = Math.max(maxEnergy, energy[i]);
        }
        
        return maxEnergy;
    }
}