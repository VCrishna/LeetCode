class Solution {
    public long gridGame(int[][] g) {
        // Step 1: Calculate the total sum of the first row (top robot path).
        // `top` initially stores the sum of all elements in the first row.
        // `bottom` keeps track of the cumulative sum of the second row as the bottom robot moves.
        long top = Arrays.stream(g[0]).asLongStream().sum(), bottom = 0, res = Long.MAX_VALUE;

        // Step 2: Iterate through each column in the grid.
        for (int i = 0; i < g[0].length; ++i) {
            // As the top robot moves past column `i`, subtract `g[0][i]` from `top`
            // since that cell is no longer reachable for the top robot.
            top -= g[0][i];
            
            // Calculate the maximum score the second robot can force the first robot to achieve
            // by choosing the better of the two sums: remaining `top` or accumulated `bottom`.
            res = Math.min(res, Math.max(top, bottom));
            
            // Add the current column's value in the second row to `bottom` as the second robot
            // moves past column `i`.
            bottom += g[1][i];
        }
        
        // Step 3: Return the minimum possible "maximum score" the second robot can enforce.
        return res;
    }
}