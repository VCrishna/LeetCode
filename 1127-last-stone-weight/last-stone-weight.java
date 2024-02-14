class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
                (a, b) -> b - a);
        for (int s : stones) {
            maxHeap.offer(s);
        }
        while (!maxHeap.isEmpty()) {
            if (maxHeap.size() == 1) {
                return maxHeap.peek();
            }
            int y = maxHeap.isEmpty() ? 0 : maxHeap.remove();
            int x = maxHeap.isEmpty() ? 0 : maxHeap.remove();
            if (x == y) {
                continue;
            } else {
                maxHeap.offer(y - x);
            }
        }
        return 0;
    }
}