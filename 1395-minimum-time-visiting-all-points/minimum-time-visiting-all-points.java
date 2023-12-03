class Solution {
    // To calculate the minimum time, you need to find the maximum difference
    // between the x-coordinates and the y-coordinates for consecutive points
    public int minTimeToVisitAllPoints(int[][] points) {
        int seconds = 0;
        for (int i = 0; i < points.length - 1; i++) {
            // int distance = findDistance(points[i], points[i + 1]);
            // seconds += distance;
            seconds += Math.max(
                Math.abs(points[i + 1][0] - points[i][0]),
                Math.abs(points[i + 1][1] - points[i][1])
            );
        }
        return seconds;
    }

    public int findDistance(int[] a, int[] b) {
        int x = b[0] - a[0];
        int y = b[1] - a[1];
        return (int) Math.sqrt((x * x) + (y * y));
    }
}
