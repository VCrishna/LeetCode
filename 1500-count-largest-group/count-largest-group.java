class Solution {
    public int countLargestGroup(int n) {
        // Create a HashMap to store the frequency of the sum of digits for numbers.
        // The key will be the sum of digits, and the value will be the count of numbers
        // from 1 to 'n' that have that sum of digits.
        Map<Integer, Integer> sumDigitCounts = new HashMap<>();

        // Iterate through numbers from 1 down to 1 (inclusive).
        // We are calculating the sum of digits for each number in this range
        // and counting how many numbers have the same sum of digits.
        int currentNumber = n;
        while (currentNumber > 0) {
            // Calculate the sum of the digits of the current number.
            int digitSum = sumOfEle(currentNumber);
            // Update the count for this digit sum in the map.
            // If the sum is already a key, increment its value (count).
            // If not, add the sum as a key with a value of 1.
            sumDigitCounts.put(digitSum, sumDigitCounts.getOrDefault(digitSum, 0) + 1);
            // Move to the next smaller number.
            currentNumber--;
        }

        // Initialize variables to find the size of the largest group and the count of such groups.
        int maxGroupSize = -1;
        int largestGroupCount = 0;

        // Iterate through the values (which represent the sizes of the groups) in the map.
        for (Integer groupSize : sumDigitCounts.values()) {
            // If the current group size is greater than the maximum group size found so far:
            if (groupSize > maxGroupSize) {
                // Update the maximum group size.
                maxGroupSize = groupSize;
                // Reset the count of groups with the largest size to 1,
                // as we've found a new largest size.
                largestGroupCount = 1;
            }
            // If the current group size is equal to the maximum group size found so far:
            else if (groupSize == maxGroupSize) {
                // Increment the count of groups that have the largest size.
                largestGroupCount++;
            }
        }

        // Return the number of groups that have the largest size.
        return largestGroupCount;
    }

    // Helper function to calculate the sum of the digits of a given integer.
    public int sumOfEle(int i) {
        int sum = 0;
        while (i > 0) {
            sum += i % 10; // Get the last digit of 'i' and add it to 'sum'.
            i /= 10; // Remove the last digit from 'i' by integer division.
        }
        return sum;
    }
}