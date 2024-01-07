class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int result = 0; // Variable to store the number of arithmetic slices
        int length = nums.length; // Length of the input array
        // Array of Maps to store the frequency of differences for each element
        Map<Integer, Integer>[] map = new Map[length];

        for (int i = 0; i < length; i++) {
            // Initialize a HashMap for each element
            map[i] = new HashMap<>();

            // Iterate through elements before the current element (i)
            for (int j = 0; j < i; j++) {
                // Calculate the difference between elements
                long diff = (long) (nums[j]) - nums[i];
                // Check if the difference is within the valid integer range
                if (diff <= Integer.MIN_VALUE || diff >= Integer.MAX_VALUE) continue;
                // Convert the difference to an integer.
                int dif = (int) diff;

                // Get the frequencies of the current difference for both elements (i and j)
                int n2 = map[i].getOrDefault(dif, 0);
                int n1 = map[j].getOrDefault(dif, 0);

                // Add the number of slices ending at the current element (i) to the result
                result += n1;

                // Calculate the new frequency for the current difference and 
                // update the map for element (i)
                int freq = n1 + n2 + 1;
                map[i].put(dif, freq);
            }
        }

        return result; // Return the total number of arithmetic slices.
    }
}
