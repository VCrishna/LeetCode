class Solution {

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        for (int[] row : matrix) {
            for (int colum : row) {
                pq.add(colum);
            }
        }
        while (k > 1) {
            pq.poll();
            k--;
        }
        return pq.peek();
    }
}
