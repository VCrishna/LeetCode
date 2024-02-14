class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b); // Min Heap
        for(int i : nums) {
            minHeap.add(i);
            if (minHeap.size() > k)
                minHeap.remove();
        }
        return minHeap.peek();
        // PriorityQueue<Integer> maxHeap = new PriorityQueue<>(nums.length, (a, b) -> b - a); // Max Heap
        // for (int num : nums) {
        //     maxHeap.offer(num);
        // }
        // for (int i = 0; i < k - 1; i++) {
        //     maxHeap.poll();
        // }
        // return maxHeap.peek();
    }
}
