class Solution {
    // To calculate the minimum time, you need to find the maximum difference
    // between the x-coordinates and the y-coordinates for consecutive points
    public int minTimeToVisitAllPoints(int[][] points) {
        int seconds = 0;
        for (int i = 0; i < points.length - 1; i++) {
            // Calculate the time (or distance) between the current point and the next point
            int xDifference = Math.abs(points[i + 1][0] - points[i][0]);
            int yDifference = Math.abs(points[i + 1][1] - points[i][1]);
            // Use the maximum difference between x and y coordinates as the time for this segment
            seconds += Math.max(xDifference, yDifference);
        }
        return seconds;
    }
}