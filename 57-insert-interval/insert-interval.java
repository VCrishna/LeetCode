class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // Creating a list to store the result intervals
        List<int[]> res = new ArrayList<>();
        // Iterating through each interval in the given list of intervals
        for (int[] interval : intervals) {
            // If newInterval is null or the current interval ends before newInterval
            // starts,
            // adding the current interval to the result list as it is not affected by
            // newInterval
            if (newInterval == null || interval[1] < newInterval[0])
                res.add(interval);
            // If the current interval starts after newInterval ends,
            // adding newInterval followed by the current interval to the result list
            else if (interval[0] > newInterval[1]) {
                res.add(newInterval);
                res.add(interval);
                newInterval = null; // Marking newInterval as null since it's already inserted
            } else {
                // Merge the overlapping intervals:
                // Updating the start of newInterval to be the minimum of the
                // current interval's start and newInterval's start
                // Updating the end of newInterval to be the maximum of the
                // current interval's end and newInterval's end
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }

        // If there's any remaining newInterval,
        // adding it to the result list
        if (newInterval != null)
            res.add(newInterval);

        // Converting the result list to a 2D array and return
        return res.toArray(new int[res.size()][]);
    }
}
