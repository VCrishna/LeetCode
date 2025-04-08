class Solution {
    public int minimumOperations(int[] nums) {
        // HashMap to store the last seen index of each unique number in the array
        Map<Integer, Integer> last = new HashMap<>();
        
        // Initialize the result (minimum number of operations) to 0
        int res = 0;

        // Iterate over each element in the input array
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            // Check if we've seen this number before AND its last occurrence is far enough back
            // The condition "last.get(num) >= 3 * res" suggests that if this number appeared
            // too far back, it may require a new operation (likely grouped in sets of 3)
            if (last.containsKey(num) && last.get(num) >= 3 * res) {
                
                // Update the number of operations needed.
                // We're simulating Math.ceil((last index + 1) / 3.0) using integer math
                // (x + 2) / 3 is a common trick to simulate ceiling division in integer math
                res = (last.get(num) + 1 + 2) / 3;
            }

            // Update the last seen index of the current number
            last.put(num, i);
        }

        // Return the computed minimum number of operations
        return res;
    }
}
