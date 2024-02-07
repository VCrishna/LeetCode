class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        // Iterate until the target point (tx, ty) is greater 
        // than or equal to the source point (sx, sy)
        while (tx >= sx && ty >= sy) {
            // Base case: if the target point matches the source point, return true
            if (tx == sx && ty == sy) {
                return true;
            }

            // Reduce the larger coordinate of the target point 
            // until it's less than the other coordinate
            if (tx > ty) {
                tx %= ty; // Subtract ty from tx if tx > ty
            } else {
                ty %= tx; // Subtract tx from ty if ty > tx
            }

            // Check if we've reached a point where one coordinate matches the source
            // and the other coordinate is a multiple of the source
            if (tx == sx) {
                // If the difference between the target and source coordinates of the other axis
                // is a multiple of the source coordinate, it means we can reach the target point.
                if ((ty - sy) % tx == 0) {
                    return true;
                } else {
                    // If not, it's impossible to reach the target point
                    return false;
                }
            }

            // Similar check for the other coordinate
            if (ty == sy) {
                if ((tx - sx) % ty == 0) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        // If we can't reach the target point within the boundaries defined by the source,
        // return false
        return false;
    }
}
