class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]); // Sort by start day

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int day = 0, i = 0, res = 0;
        int n = events.length;

        // Iterate through all possible days
        for (day = 1; day <= 100000; day++) {
            // Add all events that start today
            while (i < n && events[i][0] == day) {
                minHeap.offer(events[i][1]);
                i++;
            }

            // Remove expired events (end day < current day)
            while (!minHeap.isEmpty() && minHeap.peek() < day) {
                minHeap.poll();
            }

            // Attend the event that ends earliest
            if (!minHeap.isEmpty()) {
                minHeap.poll();
                res++;
            }

            // Early exit if no events left to process
            if (i >= n && minHeap.isEmpty()) break;
        }

        return res;
    }
}
// [[1,2],[2,3],[3,4],[1,2]]
// [1,2],[1,2],[2,3],[3,4]