class Solution {

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // MAX Heap
        for (int[] row : matrix) {
            for (int colum : row) {
                pq.add(colum);
                if(pq.size() > k)
                    pq.poll();
            }
        }
        // while (k > 1) {
        //     pq.poll();
        //     k--;
        // }
        return pq.peek();
    }
}