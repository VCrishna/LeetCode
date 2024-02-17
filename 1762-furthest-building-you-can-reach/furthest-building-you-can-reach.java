class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        // Creating a priority queue to store the height differences
        // between consecutive buildings
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // Iterating through the heights array starting from the second building
        for (int i = 1; i < heights.length; i++) {
            // Calculating the height difference between the current and previous buildings
            int diff = heights[i] - heights[i - 1];

            // If the height difference is positive (meaning we need to use bricks or
            // ladders to climb), process it
            if (diff > 0) {
                // If we have available ladders, we can climb without using bricks
                if (minHeap.size() < ladders) {
                    minHeap.add(diff); // Storing the height difference in the priority queue
                }
                // If we've used all ladders, we need to use bricks to climb
                else {
                    int brks = diff; // Initializing bricks needed to climb as the height difference
                    // If there are previously used ladders that can be optimized by using
                    // bricks instead, remove the smallest height difference from the priority queue
                    if (minHeap.size() > 0 && minHeap.peek() < diff) {
                        brks = minHeap.remove(); // Removing the smallest height difference from the queue
                        minHeap.add(diff); // Adding the current height difference to the queue
                    }
                    // If we have enough bricks to climb, 
                    // subtracting the bricks needed from the total available bricks
                    if (bricks - brks >= 0) {
                        bricks -= brks;
                    }
                    // If we don't have enough bricks to climb, 
                    // return the index of the previous building
                    else {
                        return i - 1;
                    }
                }
            }
        }
        // If we reach the end of the heights array, 
        // return the index of the last building
        return heights.length - 1;
    }
}
