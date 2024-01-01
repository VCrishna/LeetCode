class Solution {

    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> a[2] - b[2]
        );
        Arrays.sort(points, (a,b) -> calculateDistance(a) - calculateDistance(b));
        for(int i = 0; i < points.length; i++) {
            int distance = calculateDistance(points[i]);
            maxHeap.offer(
                new int[]{
                    points[i][0],points[i][1],distance
                }
            );
        }
        for(int i = 0; i < k; i++) {
            int[] current = maxHeap.poll();
            result[i][0] = current[0];
            result[i][1] = current[1];
        }
        // for(int[] p : maxHeap)
        //     System.out.println(Arrays.toString(p));
        return result;
    }

    public int calculateDistance(int[] a) {
        return a[0] * a[0] + a[1] * a[1];
    }
}
