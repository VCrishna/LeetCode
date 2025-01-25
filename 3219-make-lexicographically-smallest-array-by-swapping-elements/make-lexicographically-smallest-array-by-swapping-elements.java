class Solution {

    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        // Step 1: Create a sorted copy of the input array to determine group boundaries
        int[] numsSorted = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            numsSorted[i] = nums[i];
        Arrays.sort(numsSorted); // Sorting helps identify groups based on the limit condition

        // Step 2: Initialize variables to track groups and group assignments
        int currGroup = 0; // Keeps track of the current group index
        HashMap<Integer, Integer> numToGroup = new HashMap<>(); // Maps each number to its group index
        numToGroup.put(numsSorted[0], currGroup); // Assign the first number to the first group

        // Initialize a map to store the numbers belonging to each group
        HashMap<Integer, LinkedList<Integer>> groupToList = new HashMap<>();
        groupToList.put(
                currGroup,
                new LinkedList<Integer>(Arrays.asList(numsSorted[0])) // Add the first number to the group
        );

        // Step 3: Iterate through the sorted array and group numbers based on the limit
        for (int i = 1; i < nums.length; i++) {
            // If the difference between the current and previous number exceeds the limit,
            // start a new group
            if (Math.abs(numsSorted[i] - numsSorted[i - 1]) > limit) {
                currGroup++; // Increment the group index for a new group
            }

            // Assign the current number to its group
            numToGroup.put(numsSorted[i], currGroup);

            // Add the current number to the group list
            if (!groupToList.containsKey(currGroup)) {
                groupToList.put(currGroup, new LinkedList<Integer>());
            }
            groupToList.get(currGroup).add(numsSorted[i]); // Maintain numbers in sorted order within the group
        }

        // Step 4: Replace each element in the original array 
        // with the smallest available number from its group
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i]; // Original number
            int group = numToGroup.get(num); // Get the group to which this number belongs
            nums[i] = groupToList.get(group).pop(); // Replace with the next smallest number in the group
        }

        return nums; // Return the modified array
    }
}
