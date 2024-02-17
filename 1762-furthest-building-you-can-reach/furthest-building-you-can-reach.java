class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 1; i < heights.length; i++) {
            int diff = heights[i] - heights[i-1];
            if(diff > 0) {
                if(minHeap.size() < ladders) {
                    minHeap.add(diff);
                }
                else {
                    int brks = diff;
                    // optimize previous ladder use
                    if(minHeap.size() > 0 && minHeap.peek() < diff) {
                        brks = minHeap.remove();
                        minHeap.add(diff);
                    }
                    if(bricks - brks >= 0) {
                        bricks -= brks;
                    }
                    else {
                        return i - 1;
                    }
                }
            }
        }
        return heights.length - 1;
    }
}