class Solution {
    public long[] distance(int[] nums) {
        // HashMap to store the sum of distances 
        // and count of occurrences for each unique element
        HashMap<Integer, long[]> map = new HashMap<>();

        // Array to store the distances for each element
        long[] answer = new long[nums.length];

        // First pass: iterate through the array from left to right
        for (int i = 0; i < nums.length; i++) {
            // If the current element is encountered for the first time
            if (map.containsKey(nums[i])) {

                long[] temp = map.get(nums[i]);
                
                // Calculating the distance for the current element 
                // based on the precomputed sums and counts
                answer[i] += i * temp[1] - temp[0];

                // Updating the sum of indices and the count of 
                // occurrences for the current element
                temp[0] += i;
                temp[1]++;
            } else {
                // Initializing the sum of indices and the  count of occurrences for the current element
                long[] temp = new long[] { i, 1 };
                map.put(nums[i], temp);
            }
        }

        // Clear the map for the second pass
        map.clear();

        // Second pass: iterate through the array from right to left
        for (int i = nums.length - 1; i >= 0; i--) {
            // If the current element is encountered for the first time in the second pass
            if (map.containsKey(nums[i])) {
                long[] temp = map.get(nums[i]);

                // Calculate the remaining distance for the current element based on the
                // precomputed sums and counts
                answer[i] += temp[0] - i * temp[1];

                // Update the sum of indices and the count of occurrences for the current
                // element
                temp[0] += i;
                temp[1]++;
            } else {
                // Initialize the sum of indices and the count of occurrences for the current
                // element
                long[] temp = new long[] { i, 1 };
                map.put(nums[i], temp);
            }
        }

        // Return the array containing the calculated distances
        return answer;
    }

    /**
     * Time Limit Exceeded
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public long[] distance_BRUTE_FORCE(int[] nums) {
        long[] result = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == nums[i] && j != i) {
                    sum += Math.abs(j - i);
                }
            }
            result[i] = sum;
        }

        return result;
    }
}