class TaskManager {
    // PriorityQueue to always give us the "highest-priority" task quickly
    // Each task is stored as {priority, taskId}
    // Comparator ensures tasks are sorted:
    //   1. Higher priority comes first
    //   2. If priorities are equal, higher taskId comes first
    private PriorityQueue<int[]> pq;

    // Maps taskId → current priority
    // Used to check if a task entry in pq is still valid (latest priority) or outdated
    private Map<Integer,Integer> taskPriority;

    // Maps taskId → owner (userId)
    // Helps us know who owns the task when executing it
    private Map<Integer,Integer> taskOwner;


    // Constructor: initializes everything with an initial list of tasks
    public TaskManager(List<List<Integer>> tasks) {
        // Custom comparator:
        // - Sort by descending priority
        // - If priority same, sort by descending taskId
        pq = new PriorityQueue<>((a,b) -> {
            if (b[0] != a[0]) return b[0] - a[0]; // Higher priority first
            return b[1] - a[1];                   // Higher taskId first
        });

        taskPriority = new HashMap<>();
        taskOwner = new HashMap<>();

        // Add all given tasks
        for (List<Integer> t : tasks) 
            add(t.get(0), t.get(1), t.get(2));
    }


    // Add a new task
    // userId = who owns the task
    // taskId = unique task identifier
    // priority = importance of the task
    public void add(int userId, int taskId, int priority) {
        pq.add(new int[]{priority, taskId});  // Add to heap
        taskPriority.put(taskId, priority);   // Record latest priority
        taskOwner.put(taskId, userId);        // Record owner
    }


    // Edit (update) the priority of an existing task
    public void edit(int taskId, int newPriority) {
        pq.add(new int[]{newPriority, taskId}); // Push new entry to heap
        taskPriority.put(taskId, newPriority);  // Update priority in map
        // Old priority entry remains in heap, but will be ignored later (lazy deletion)
    }


    // Remove task (mark invalid)
    public void rmv(int taskId) {
        taskPriority.put(taskId, -1); // Special marker = task is deleted
        // No need to remove from pq directly (expensive)
        // Lazy removal happens during execTop()
    }


    // Execute the highest-priority task (return its owner/userId)
    public int execTop() {
        while (!pq.isEmpty()) {
            int[] t = pq.poll();     // Get best candidate
            int p = t[0], id = t[1];

            // Check if this task is still valid:
            // - If taskPriority matches this priority, it's the latest version
            // - If not, it's outdated or removed, so skip it
            if (taskPriority.getOrDefault(id, -2) == p) {
                taskPriority.put(id, -1);   // Mark executed as removed
                return taskOwner.getOrDefault(id, -1); // Return owner
            }
        }
        return -1; // No valid task found
    }
}


/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */