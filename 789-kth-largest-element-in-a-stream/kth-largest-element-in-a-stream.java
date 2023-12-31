class KthLargest {
    int k;
    PriorityQueue<Integer> minHeap;
    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<Integer>(
            (a,b) -> a - b
        );
        this.k = k;
        for(int i : nums) {
            minHeap.add(i);
        }
        while(minHeap.size() > k) {
            minHeap.poll();
        }
    }
    
    public int add(int val) {
        minHeap.add(val);
        while(minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */