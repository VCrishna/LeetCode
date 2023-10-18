public class Solution {
    private Map<Integer, List<Integer>> adj;
    private int[] time;
    private Map<Integer, Integer> maxTime;

    public int minimumTime(int n, int[][] relations, int[] time) {
        this.adj = new HashMap<>();
        this.time = time;
        this.maxTime = new HashMap<>();

        for (int[] relation : relations) {
            adj.computeIfAbsent(relation[0], k -> new ArrayList<>()).add(relation[1]);
        }

        for (int i = 1; i <= n; i++) {
            dfs(i);
        }

        return Collections.max(maxTime.values());
    }

    private int dfs(int src) {
        if (maxTime.containsKey(src)) {
            return maxTime.get(src);
        }

        int res = time[src - 1];
        if (adj.containsKey(src)) {
            for (int nei : adj.get(src)) {
                res = Math.max(res, time[src - 1] + dfs(nei));
            }
        }
        maxTime.put(src, res);
        return res;
    }
}
