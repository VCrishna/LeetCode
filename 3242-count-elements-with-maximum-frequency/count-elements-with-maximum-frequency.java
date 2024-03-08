class Solution {
    public int maxFrequencyElements(int[] nums) {
        // Creating a HashMap to store the frequency of each element
        Map<Integer, Integer> map = new HashMap<>();

        // Initializing the maximum frequency to -1
        int maxFreq = -1;

        // Iterating through each element in the array
        for (int i : nums) {
            // Updating the frequency of the current element in the map
            map.put(i, map.getOrDefault(i, 0) + 1);

            // Updating the maximum frequency if the frequency 
            // of the current element is greater
            maxFreq = Math.max(maxFreq, map.get(i));
        }

        // Initializing the result variable to 0
        int result = 0;

        // Iterating through the values (frequencies) in the map
        for (int i : map.values()) {
            // If the frequency equals the maximum frequency, 
            // add it to the result
            result += i == maxFreq ? i : 0;
        }

        // Returning the final result
        return result;
    }
}
