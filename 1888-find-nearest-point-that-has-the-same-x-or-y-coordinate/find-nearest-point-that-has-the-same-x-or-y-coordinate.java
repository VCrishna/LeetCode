class Solution {
    int x;
    int y;
    public int nearestValidPoint(int x, int y, int[][] points) {
        this.x = x;
        this.y = y;
        int minValue = Integer.MAX_VALUE;
        int index = -1;
        for(int i = 0; i < points.length; i++) {
            if(points[i][0] == x || points[i][1] == y) {
                int distance = manhattanDist(points[i]);
                if(distance < minValue) {
                    minValue = distance;
                    index = i;
                }
            }
        }
        return index;

    }
    public int manhattanDist(int[] a) {
        return Math.abs(x - a[0]) + Math.abs(y - a[1]);
    }
}