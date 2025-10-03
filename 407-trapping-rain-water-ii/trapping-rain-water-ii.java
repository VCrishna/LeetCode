class Solution {
    public int trapRainWater(int[][] height) {
        int n = height.length; // number of rows
        int m = height[0].length; // number of columns

        // Min-heap (priority queue) based on cell height
        // Each entry = {height, row, col}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Visited matrix to track which cells are already processed
        boolean[][] vis = new boolean[n][m];

        // Step 1: Add boundary cells into the min-heap
        // Because water cannot escape outside the boundary,
        // the lowest boundary defines the "bowl" for trapping water.

        // Add leftmost and rightmost columns
        for (int i = 0; i < n; i++) {
            vis[i][0] = true;
            vis[i][m - 1] = true;
            pq.offer(new int[] { height[i][0], i, 0 });
            pq.offer(new int[] { height[i][m - 1], i, m - 1 });
        }

        // Add top and bottom rows
        for (int i = 0; i < m; i++) {
            vis[0][i] = true;
            vis[n - 1][i] = true;
            pq.offer(new int[] { height[0][i], 0, i });
            pq.offer(new int[] { height[n - 1][i], n - 1, i });
        }

        // Final answer (total trapped water)
        int ans = 0;

        // Directions for 4-neighbors (up, left, down, right)
        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, -1, 0, 1 };

        // Step 2: Process cells from lowest boundary upward
        // Always expand from the current lowest "wall"
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int h = curr[0]; // height of current boundary cell
            int r = curr[1];
            int c = curr[2];

            // Explore neighbors
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                // If neighbor is inside grid and not visited
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !vis[nr][nc]) {

                    // If neighbor is lower than current boundary (h),
                    // water can be trapped.
                    // Amount = h - neighborHeight (if positive)
                    ans += Math.max(0, h - height[nr][nc]);

                    // The effective "wall height" for neighbor is:
                    // max(current boundary height, neighbor's actual height)
                    // Because water rises up to the min boundary level.
                    pq.offer(new int[] { Math.max(h, height[nr][nc]), nr, nc });

                    // Mark neighbor visited
                    vis[nr][nc] = true;
                }
            }
        }

        return ans;
    }
}
