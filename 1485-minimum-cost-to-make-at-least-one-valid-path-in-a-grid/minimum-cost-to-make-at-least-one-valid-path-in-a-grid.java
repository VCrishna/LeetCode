class Solution {
    /**
     * It is similar to the tradiitonal BFS, just instead of a heap, a deque is
     * used. When we visit a neighbouring node, we check if the cost would increase.
     * If it does not, we add it to the front of the queue, otherwise we send it to
     * the back of the queue. This ensures the minimum costs stay in the front of
     * the queue.
     * 
     * Time complexity:
     * O(n∗m): Worst case where each node needs to be visited once.
     * 
     * Space complexity:
     * O(n∗m): For storing the Deque and the Visited grid that stores which cells
     * have been visited to avoid revisits.
     */
    // Stores the directions in terms of integers
    static final int dir[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean visited[][] = new boolean[m][n]; // For storing which cells have been visited
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] { 0, 0, 0 }); // Array -> {current x, current y, current cost}
        while (!dq.isEmpty()) {
            int curr[] = dq.poll(); // lowest cost cell
            if (visited[curr[0]][curr[1]])
                continue; // already visited
            visited[curr[0]][curr[1]] = true; // visiting node
            if (curr[0] == m - 1 && curr[1] == n - 1)
                return curr[2]; // base case, reached the end
            for (int idx = 0; idx < 4; idx++) // All possible directions
            {
                int nx = curr[0] + dir[idx][0], ny = curr[1] + dir[idx][1]; // Coordinates of next cell
                if (nx < 0 || ny < 0 || nx >= m || ny >= n || visited[nx][ny])
                    continue; // Cell is either visited or out-of-grid
                if (idx == grid[curr[0]][curr[1]] - 1) // 0 cost transition
                    dq.offerFirst(new int[] { nx, ny, curr[2] });
                else
                    dq.offerLast(new int[] { nx, ny, curr[2] + 1 });
            }
        }
        return -1; // base return
    }
}