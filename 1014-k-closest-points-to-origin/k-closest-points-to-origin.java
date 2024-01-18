class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> calculateDistance(a) - calculateDistance(b)
        );
        for (int i = 0; i < points.length; i++) {
            minHeap.offer(new int[] { points[i][0], points[i][1] });
        }
        for (int i = 0; i < k; i++) {
            int[] current = minHeap.poll();
            result[i][0] = current[0];
            result[i][1] = current[1];
        }
        return result;
    }

    public int calculateDistance(int[] a) {
        return a[0] * a[0] + a[1] * a[1];
    }
}
