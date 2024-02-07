class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx >= sx && ty >= sy) {
            if (tx == sx && ty == sy) {
                return true;
            }

            if (tx > ty) {
                tx %= ty;
            } else {
                ty %= tx;
            }

            if (tx == sx) {
                if ((ty - sy) % tx == 0) {
                    return true;
                } else {
                    return false;
                }
            }

            if (ty == sy) {
                if ((tx - sx) % ty == 0) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
    // public boolean reachingPoints(int sx, int sy, int tx, int ty) {
    //     // Base case: if starting point matches the target point
    //     if (sx == tx && sy == ty) {
    //         return true;
    //     }

    //     // Check if the target point can be reached from the current point
    //     if (tx >= sx && ty >= sy) {
    //         // Try to reach the target by subtracting the larger coordinate
    //         if (tx > ty) {
    //             return reachingPoints(sx, sy, tx - Math.max(ty, 1), ty);
    //         } else {
    //             return reachingPoints(sx, sy, tx, ty - Math.max(tx, 1));
    //         }
    //     }

    //     return false;
    // }
}