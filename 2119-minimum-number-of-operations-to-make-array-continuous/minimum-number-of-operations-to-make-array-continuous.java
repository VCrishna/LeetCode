class Solution {

    public int minOperations(int[] nums) {
        // The total number of numbers in the given list.
        int length = nums.length;

        // This will store our answer, initialized to the total number as a worst-case scenario.
        int result = length;

        // A set to capture unique numbers in the list since repeated numbers don't change our answer.
        Set<Integer> unique_elements = new HashSet<>();
        for (int i : nums) unique_elements.add(i);

        // Transfer unique numbers from the set to an array for easy manipulation.
        int[] newNums = new int[unique_elements.size()];
        int index = 0;
        for (int i : unique_elements) newNums[index++] = i;

        // Sort the array to handle numbers in increasing order.
        Arrays.sort(newNums);

        // The main loop checks how many operations are needed for each number to be the start of a consecutive sequence.
        for (int i = 0; i < newNums.length; i++) {
            // Assume current number is the starting point of a consecutive sequence.
            int left = newNums[i];

            // Calculate the end of the consecutive sequence if it starts at the current number.
            int right = left + length - 1;

            // Find the index where 'right' would be positioned in the sorted list.
            int j = binarySearch(newNums, right);

            // Calculate how many numbers are within the sequence [left, right].
            int count = j - i;

            // Update our answer, trying to minimize the number of operations.
            // Operations are calculated as total number minus numbers that are already in sequence.
            result = Math.min(result, length - count);
        }

        return result;
    }

    // A binary search to find the index of a given number, or where it would be if it were in the array.
    public int binarySearch(int[] newNums, int target) {
        int left = 0;
        int right = newNums.length;

        // Standard binary search.
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (newNums[middle] > target) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        return left;
    }
}
