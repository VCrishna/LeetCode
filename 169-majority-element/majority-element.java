class Solution {
    // Using Boyer-Moore Voting Algorithm
    public int majorityElement(int[] nums) {
        int count = 0; // Initialize a counter for tracking occurrences
        Integer majorityEle = null; // Initialize a variable to store the majority element

        // Iterating through the array
        for (int num : nums) {
            if (count == 0) { // If count is 0, meaning no majority candidate yet
                majorityEle = num; // Set the current number as the potential majority candidate
            }
            // Updating the count based on whether the current number is equal to the
            // potential majority candidate
            count += (num == majorityEle) ? 1 : -1;
        }
        // At the end of the loop, 
        // majorityEle should hold the majority element (if it exists)
        return majorityEle; // Return the majority element
    }

    // Using HashMap to count occurrences (Extra Space)
    public int majorityElement_EXTRA_SPACE(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); // Create a HashMap to count occurrences

        // Counting occurrences of each number in the array
        for (int i : nums)
            map.put(i, map.getOrDefault(i, 0) + 1);

        // Iterating through the numbers in the array
        for (int i : nums) {
            // Checking if the occurrence of the current number is 
            // greater than half of the array length
            if (map.get(i) > nums.length / 2)
                return i; // Return the number as the majority element
        }
        return 0; // If no majority element found, return 0
    }
}