class Solution {
    public int longestConsecutive(int[] nums) {
        // Checking if the array is empty, return 0 if so
        if (nums.length == 0)
            return 0;

        // Checking if the array has only one element, return 1 if so
        if (nums.length == 1)
            return 1;

        // Creating a set to store unique elements from the array
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }

        // Initializing a variable to track the length of 
        // the longest consecutive sequence
        int longestSequence = 0;

        // Iterating through the elements of the array
        for (int i : nums) {
            int currentSequence = i;
            int sequence = 0;

            // Checking if this is the starting element of a sequence
            if (!set.contains(currentSequence - 1)) {
                // If yes, iterating to find the length of the consecutive sequence
                while (set.contains(currentSequence + sequence)) {
                    sequence++;
                }
            }

            // Updating the longest consecutive sequence length
            longestSequence = Math.max(sequence, longestSequence);
        }

        // Returning the length of the longest consecutive sequence
        return longestSequence;
    }
}
