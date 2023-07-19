class Solution {

    // My Method
    public int eraseOverlapIntervalsK(int[][] intervals) {
        if (intervals.length <= 1) return 0;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        // System.out.println(Arrays.deepToString(intervals));
        int result = 0;
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < intervals.length; i++) {
            if (stack.isEmpty()) stack.push(intervals[i]); else {
                if (stack.peek()[1] > intervals[i][0]) {
                    result++;
                    continue;
                } else {
                    stack.push(intervals[i]);
                }
            }
        }
        return intervals.length - stack.size();
    }

    public int eraseOverlapIntervalsCOPILOT(int[][] intervals) {
        if (intervals.length <= 1) return 0;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int end = intervals[0][1];
        int result = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                result++;
                // Update end time to the minimum end time between the current and previous interval
                end = Math.min(end, intervals[i][1]);
            } else {
end = intervals[i][1];
            }
        }

        return result;
    }
    // LeetCode Soln
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1) return 0;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int end = Integer.MIN_VALUE;
        int result = 0;
        for (int i = 0; i < intervals.length; i++) {
            int source = intervals[i][0];
            int destination = intervals[i][1];

            if (source >= end) {
                end = destination;
            }
            else
                result++;
        }
        return result;
    }
}
