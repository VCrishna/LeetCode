class Solution {
    public int longestSubarray(int[] nums) {
        int maxValue = 0;            // Tracks the maximum value in the array
        int longestStreak = 0;       // Final answer
        int currentStreak = 0;       // Current count of consecutive maxValue elements

        for (int num : nums) {
            if (num > maxValue) {
                // Found a new maximum, reset everything
                maxValue = num;
                currentStreak = 1;
                longestStreak = 1;
            } else if (num == maxValue) {
                // Extend the streak of maxValue
                currentStreak++;
                longestStreak = Math.max(longestStreak, currentStreak);
            } else {
                // num < maxValue, so streak breaks
                currentStreak = 0;
            }
        }
        return longestStreak;
    }
}
