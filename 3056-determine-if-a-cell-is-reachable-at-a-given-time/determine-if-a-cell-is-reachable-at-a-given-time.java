class Solution {

    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        // Check if the starting point is the same as the target point.
        if (sx == fx && sy == fy) {
            // If they are the same, check if time is 1, and return false (impossible to stay at the same cell for 1 second).
            if (t == 1) {
                return false;
            }
        }

        // Calculate the absolute differences in x and y coordinates between the starting and target points.
        int xDifference = Math.abs(sx - fx);
        int yDifference = Math.abs(sy - fy);

        // Calculate the maximum difference between xDifference and yDifference.
        int maxDifference = Math.max(xDifference, yDifference);

        // Check if the maximum difference is less than or equal to the given time.
        return maxDifference <= t;
    }

    // public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
    //     if (sx == fx && sy == fy) {
    //         // Points are already at the same location, return false
    //         return false;
    //     }
    //     // Calculate the absolute differences between start and end points along x-axis and y-axis
    //     int diff = Math.abs(sx - fx);
    //     int yDiff = Math.abs(sy - fy);

    //     // Calculate the diagonal distance, which is the minimum of diff and yDiff
    //     int diagonalDistance = Math.min(diff, yDiff);

    //     // Update differences by subtracting the diagonal distance
    //     diff -= diagonalDistance;
    //     yDiff -= diagonalDistance;

    //     // Update diagonal distance by adding the updated differences
    //     diagonalDistance += diff + yDiff;

    //     // Check conditions
    //     if (diagonalDistance < 0) {
    //         // If diagonal distance is negative, return true if t is not equal to 1, otherwise return false
    //         return t != 1;
    //     }

    //     // Return true if diagonal distance is less than or equal to t, otherwise return false
    //     return diagonalDistance <= t;
    // }

    public boolean isReachableAtTime_different_method(int sx, int sy, int fx, int fy, int t) {
        // Check if the starting point is the same as the target point.
        if (sx == fx && sy == fy) {
            // If they are the same, check if time is 1, and return false (impossible to stay at the same cell for 1 second).
            if (t == 1) {
                return false;
            }
        }

        // Calculate the absolute differences in x and y coordinates between the starting and target points.
        int xDifference = sx - fx;
        int yDifference = sy - fy;

        // Ensure that xDifference and yDifference are non-negative.
        if (xDifference < 0) {
            xDifference = -xDifference;
        }
        if (yDifference < 0) {
            yDifference = -yDifference;
        }

        // Calculate the maximum difference between xDifference and yDifference.
        int maxDifference = Math.max(xDifference, yDifference);

        // Check if the maximum difference is less than or equal to the given time.
        if (maxDifference <= t) {
            return true; // It's possible to reach the target within the specified time.
        }

        // If the maximum difference is greater than the given time, return false.
        return false;
    }
}
