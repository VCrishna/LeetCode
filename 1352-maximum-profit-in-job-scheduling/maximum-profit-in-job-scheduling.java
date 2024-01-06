class Solution {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] jobs = new int[startTime.length][3];
        for (int i = 0; i < startTime.length; i++) {
            jobs[i] = new int[] { startTime[i], endTime[i], profit[i] };
        }
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int maxProfit = 0;
        for (int[] job : jobs) {
            Integer entryTillStartTime = treeMap.floorKey(job[0]);
            int maxProfitTillStartTime = entryTillStartTime == null ? 0 : treeMap.get(entryTillStartTime);
            maxProfit = Math.max(maxProfit, maxProfitTillStartTime + job[2]);
            treeMap.put(job[1], maxProfit);
        }

        return treeMap.lastEntry().getValue();
    }
}
