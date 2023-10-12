class Solution {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        // Sort the processorTime list in ascending order
        // This ensures that we sequentially get processors in the order they become available.
        Collections.sort(processorTime);

        // Sort the tasks list in descending order
        // Sorting tasks in descending order allows us to handle the longest tasks first.
        Collections.sort(tasks, (a, b) -> (b - a));

        // Initialize the result to -1; it will store the latest task completion time across all processors
        int result = -1;

        // Iterate over each processor
        for (int i = 0; i < processorTime.size(); i++) {
            // Calculate the completion time for the longest task assigned to this processor.
            // The formula takes the processor's start time and adds the time of the largest unassigned task.
            // The i * 4 is used to pick every 4th task, which means we're only considering the longest task
            // for every group of 4 tasks per processor.
            int completionTime = processorTime.get(i) + tasks.get(i * 4);

            // Update the result to be the latest completion time found so far.
            result = Math.max(result, completionTime);
        }

        // Return the maximum completion time
        return result;
    }
}
