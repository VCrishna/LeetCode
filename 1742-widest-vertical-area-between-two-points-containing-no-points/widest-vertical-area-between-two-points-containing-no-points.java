class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int maxWidth = 0;
        // Sorting the points based on their x-coordinates (first column)
        Arrays.sort(points, (a, b) -> a[0] - b[0]);
        for (int i = 1; i < points.length; i++) {
            maxWidth = Math.max(maxWidth, points[i][0] - points[i - 1][0]);
        }
        return maxWidth;
    }
}
