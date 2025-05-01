class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        // Sort tasks in increasing order (easier to assign easier tasks first)
        Arrays.sort(tasks);
        // Sort workers in increasing order (strongest workers at the end)
        Arrays.sort(workers);

        int low = 0;              // Minimum possible tasks
        int high = tasks.length; // Maximum possible tasks (can't assign more than available)
        int ans = 0;             // Stores the best (maximum) valid assignment

        // Binary search on the number of tasks we can assign
        while (low <= high) {
            int mid = (low + high) / 2;  // Try to assign `mid` tasks

            // Check if it's possible to assign `mid` tasks
            if (isPossible(tasks, workers, pills, strength, mid)) {
                ans = mid;       // It's possible, try for more
                low = mid + 1;
            } else {
                high = mid - 1;  // Not possible, try fewer
            }
        }

        return ans;  // Return the maximum number of assignable tasks
    }

    // Helper function to check if `n` tasks can be assigned
    public boolean isPossible(int[] tasks, int[] workers, int pills, int strength, int n) {
        // Not enough workers or tasks for `n` assignments
        if (Math.min(workers.length, tasks.length) < n)
            return false;

        TreeMap<Integer, Integer> tm = new TreeMap<>();

        // Add the smallest `n` tasks into TreeMap (task difficulty → frequency)
        for (int i = 0; i < n; i++) {
            tm.put(tasks[i], tm.getOrDefault(tasks[i], 0) + 1);
        }

        // We'll use the `n` strongest workers (i.e., last `n` in sorted workers)
        for (int j = workers.length - n; j < workers.length; j++) {
            int smallest = tm.firstKey();  // Pick the smallest task remaining

            // Case 1: Worker can’t do it without a pill
            if (workers[j] < smallest) {
                if (pills == 0)
                    return false; // No pill left, cannot assign this task
                pills--; // Use a pill

                // Try to find the largest task this worker can do with a pill
                Integer boostedTask = tm.floorKey(workers[j] + strength);
                if (boostedTask != null)
                    smallest = boostedTask;
                else
                    return false; // Even with pill, no valid task found
            }

            // Assign the task `smallest` to the worker
            // Remove or decrement it from TreeMap
            if (tm.get(smallest) == 1)
                tm.remove(smallest); // Last occurrence
            else
                tm.put(smallest, tm.get(smallest) - 1);
        }

        return true;  // All tasks successfully assigned
    }
}
