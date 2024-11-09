class Solution {
    public long minEnd(int n, int x) {
        // Initialize the result with the given value x
        long result = x;
        
        // Iterate from 1 to n-1 (total n-1 iterations)
        for(int i = 1; i < n; i++) {
            // Increment the current 'result' by 1.
            // Apply a bitwise OR operation with 'x' to ensure the result has all bits set as in 'x'.
            // This OR operation helps preserve the bits from 'x' in the final value.
            result = (result + 1) | x;
        }
        
        // Return the final computed result
        return result;
    }
}
