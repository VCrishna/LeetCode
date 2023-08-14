class Solution {
    public int findKthLargest(int[] nums, int k) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // Max Heap
        // for(int i : nums) {
        //     pq.add(i);
        // }
        // while(k >= 0) {
        //     pq.remove();
        //     k--;
        // }
        // return pq.peek();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b); // Max Heap
        for(int i : nums) {
            pq.add(i);
        }
        while(pq.size() > k) {
            pq.remove();
        }
        return pq.peek();
    }
}
