import java.util.Arrays;

class Solution {
    public int findMinArrowShots(int[][] points) {
        // Base case: if there are no points, return 0 as no arrows are needed
        if (points.length == 0)
            return 0;

        // Sort the points based on their end positions
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1; // Initialize the number of arrows needed to 1
        int end = points[0][1]; // Initialize the end position with the end of the first point

        // Iterate through the sorted points starting from the second point
        for (int i = 1; i < points.length; i++) {
            // If the start position of the current balloon is greater than the end
            // position:
            if (points[i][0] > end) {
                // It means a new arrow is needed:
                arrows++; // Increment the arrow count
                end = points[i][1]; // Update the end position to the end of the current balloon
            }
        }

        // Return the final arrow count
        return arrows;
    }
}
