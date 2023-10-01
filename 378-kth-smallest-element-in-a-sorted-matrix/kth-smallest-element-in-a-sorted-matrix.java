class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int[] row : matrix) {
            for (int i : row) {
                maxHeap.add(i);
                if(maxHeap.size()>k)
                    maxHeap.poll();
            }
        }
        return maxHeap.peek();
    }
}
