class Solution {
    public int countDays(int days, int[][] meetings) {
        int freeDays = 0;
        int latestEnd = 0;

        // Sort meetings based on starting times
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];
            // If there's a gap between the previous end and the current start
            if (start > latestEnd + 1) {
                freeDays += start - latestEnd - 1;
            }

            // Extend the latest end to cover merged intervals
            latestEnd = Math.max(latestEnd, end);
        }

        // Add remaining days after the last meeting ends
        freeDays += days - latestEnd;

        return freeDays;
    }
}