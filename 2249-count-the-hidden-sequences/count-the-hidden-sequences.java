class Solution {

    public int numberOfArrays(int[] differences, int lower, int upper) {
        int x = 0, y = 0, cur = 0;  // Initialize:
                                    // cur = current cumulative sum (starting from 0)
                                    // x = minimum value reached so far
                                    // y = maximum value reached so far
                                    
        for (int d : differences) {  // Iterate through all the differences
            cur += d;  // Update the current cumulative sum based on difference
            
            x = Math.min(x, cur);  // Track the smallest value reached so far
            y = Math.max(y, cur);  // Track the largest value reached so far
            
            // If the range becomes larger than allowed (upper - lower),
            // it's impossible to create a valid array
            if (y - x > upper - lower) {
                return 0;
            }
        }
        
        // Intuition:
        // The valid starting values (first element of array) must be such that
        // when you add all the differences step-by-step,
        // you never go below 'lower' and never go above 'upper'.
        //
        // After knowing how far you can drop (x) and how far you can rise (y),
        // the number of possible starting values is:
        //
        // Total available range (upper - lower)
        // minus
        // Necessary movement range (y - x)
        // plus 1 (since both ends are inclusive)
        
        return (upper - lower) - (y - x) + 1;
    }
}
