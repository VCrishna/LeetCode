class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int maxWidth = 0;
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        for (int i = 1; i < points.length; i++) {
            maxWidth = Math.max(maxWidth, points[i][0] - points[i - 1][0]);
        }
        return maxWidth;
    }
}
