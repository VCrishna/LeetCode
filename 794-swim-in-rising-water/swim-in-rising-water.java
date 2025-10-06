class Solution {
    // Directions for 4-way movement: up, down, left, right
    private static final int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public int swimInWater(int[][] grid) {
        int n = grid.length;

        // dist[i][j] = minimum time required to reach cell (i,j)
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(dist[i], n * n); // initialize with large number

        // Starting point: we can only start swimming when water level reaches grid[0][0]
        dist[0][0] = grid[0][0];

        // TreeSet = acts like a priority queue, but we can remove specific elements
        // Stores int[]{row, col, current_time}, sorted by current_time (ascending)
        TreeSet<int[]> set = new TreeSet<>((a, b) -> a[2] == b[2]
                ? (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0])
                : a[2] - b[2]);

        set.add(new int[] { 0, 0, grid[0][0] }); // start node

        // Dijkstra’s main loop
        while (!set.isEmpty()) {
            // Pick the cell with the smallest "time" (min water level required)
            int[] p = set.pollFirst();
            int i = p[0], j = p[1], time = p[2];

            // If we reached the bottom-right corner → done
            if (i == n - 1 && j == n - 1)
                break;

            // Explore all 4 directions
            for (int[] d : dir) {
                int x = i + d[0], y = j + d[1];
                if (x < 0 || x >= n || y < 0 || y >= n)
                    continue; // skip invalid cells

                // Compute the "alternative time" to reach (x, y)
                // If grid[x][y] > current time, we must wait for water to rise
                int alt = time + Math.max(0, grid[x][y] - time);

                // If we found a faster way to reach (x, y)
                if (alt < dist[x][y]) {
                    int[] key = { x, y, dist[x][y] };
                    set.remove(key); // remove old record (if exists)
                    key[2] = dist[x][y] = alt; // update with better time
                    set.add(key); // reinsert with updated time
                }
            }
        }

        // Final answer: minimum time to reach bottom-right cell
        return dist[n - 1][n - 1];
    }
}
