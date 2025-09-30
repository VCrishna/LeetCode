class Solution {
    public int triangularSum(int[] nums) {
        // Start the recursive process with the full array
        return find(nums, nums.length);
    }
    
    // Recursive helper: reduces array size step by step until only 1 element remains
    public int find(int[] a, int n) {
        // Base case: if only one element is left, that’s the triangular sum
        if (n == 1)
            return a[0];
            
        // Step: Build the next "row" by replacing each element
        // with the sum of itself and the next element, mod 10
        for (int i = 0; i < n - 1; i++) {
            a[i] = (a[i] + a[i + 1]) % 10;
        }

        // Recurse with reduced array length (since last element is no longer needed)
        return find(a, n - 1);
    }
}
