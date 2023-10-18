public class Solution {
    // Instance variables:
    // adj: adjacency list for our directed graph.
    // time: array of time taken for each course.
    // maxTime: maps each course to its maximum time including prerequisites.
    private Map<Integer, List<Integer>> adj;
    private int[] time;
    private Map<Integer, Integer> maxTime;

    public int minimumTime(int n, int[][] relations, int[] time) {
        // n: the number of courses.
        // relations: a 2D array where each entry indicates a directed edge from course i to j.
        // time: an array indicating time for each course.
        // Initializing our instance variables.
        this.adj = new HashMap<>();
        this.time = time;
        this.maxTime = new HashMap<>();
        // Looping through each relation.
        for (int[] relation : relations) {
            // For every relation, we're updating the adjacency list.
            // If relation[0] doesn't have an entry, it creates an empty list,
            // then appends relation[1] to that course's list.
            adj.computeIfAbsent(relation[0], k -> new ArrayList<>()).add(relation[1]);
        }
        // Looping through every course.
        for (int i = 1; i <= n; i++) {
            // Performing a depth-first search starting from course i.
            // This will calculate and store the maximum time required for each course in the maxTime map.
            dfs(i);
        }
        // Returning the maximum value from the maxTime map, which gives the longest time to complete any course.
        return Collections.max(maxTime.values());
    }

    // Depth First Search method.
    // src: the current course we're exploring.
    private int dfs(int src) {
        // If we've already calculated the max time for this course previously, return that value.
        if (maxTime.containsKey(src)) {
            return maxTime.get(src);
        }
        // Start with the base time required for the current course.
        // -1 is because courses are 1-indexed but array is 0-indexed.
        int res = time[src - 1];
        // If the current course has prerequisites.
        if (adj.containsKey(src)) {
            for (int nei : adj.get(src)) {
                // Loop through every prerequisite
                // Calculate the total time required if we were to take the current course after the prerequisite.
                // Compare this with our current 'res' and take the maximum.
                res = Math.max(res, time[src - 1] + dfs(nei));
            }
        }
        // Storing the maximum time required for the current course.
        maxTime.put(src, res);
        return res;
    }
}
