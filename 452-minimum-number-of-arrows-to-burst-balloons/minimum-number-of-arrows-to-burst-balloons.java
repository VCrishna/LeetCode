import java.util.Arrays;

class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) 
            return 0;
        
        // Sort the points based on their end positions
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        
        int arrows = 1; // Initialize the number of arrows needed to 1
        int end = points[0][1]; // Initialize the end position with the end of the first point
        
        for (int i = 1; i < points.length; i++) {
            // If the current balloon doesn't intersect with the previous one
            // Increment the arrow count and update the end position
            if (points[i][0] > end) {
                arrows++;
                end = points[i][1];
            }
        }
        
        return arrows;
    }
}
