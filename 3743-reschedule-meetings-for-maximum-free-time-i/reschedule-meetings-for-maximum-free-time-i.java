public class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int res = 0;

        // Prefix sum to store total busy time up to each index
        int[] sum = new int[n + 1];

        // Calculate total duration of each event and build prefix sum
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + (endTime[i] - startTime[i]);
        }

        // Try skipping each window of k consecutive events
        for (int i = k - 1; i < n; i++) {
            // right: the end time of the event right after the k-sized window
            // if we're at the last event, right is the total eventTime
            int right = i == n - 1 ? eventTime : startTime[i + 1];

            // left: the end time of the event just before the k-sized window
            // if we're skipping the first k events, left is 0 (start of day)
            int left = i == k - 1 ? 0 : endTime[i - k];

            // Time between left and right is total gap
            // Subtract the sum of busy time **within** the window we skip
            int gap = right - left - (sum[i + 1] - sum[i - k + 1]);

            // Maximize the resulting free time
            res = Math.max(res, gap);
        }

        return res;
    }
}
