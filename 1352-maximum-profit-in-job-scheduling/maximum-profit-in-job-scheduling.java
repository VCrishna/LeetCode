class Solution {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        // Create a 2D array 'jobs' to store each job's start time, end time, and profit
        int[][] jobs = new int[startTime.length][3];
        for (int i = 0; i < startTime.length; i++) {
            jobs[i] = new int[] { startTime[i], endTime[i], profit[i] };
        }

        // Sort the 'jobs' array based on the end times in ascending order
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);

        // Use a TreeMap to track the maximum profit achievable until each end time
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int maxProfit = 0;

        // Iterate through each job
        for (int[] job : jobs) {
            // Find the maximum profit achievable until the start time of the current job
            Integer entryTillStartTime = treeMap.floorKey(job[0]);
            int maxProfitTillStartTime = entryTillStartTime == null ? 0 : treeMap.get(entryTillStartTime);

            // Calculate the maximum profit achievable by including the current job
            maxProfit = Math.max(maxProfit, maxProfitTillStartTime + job[2]);

            // Update the TreeMap with the maximum profit achievable until the end time of the current job
            treeMap.put(job[1], maxProfit);
        }

        return maxProfit; // Return the maximum profit achievable
    }
}
