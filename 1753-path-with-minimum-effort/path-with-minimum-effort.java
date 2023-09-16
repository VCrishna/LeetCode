/**
    Let's take a look on our interesting problem\U0001f680
Our problem says that we have matrix M * N of cells and each cell has some value of height.
our goal is to find the path that has minimum effort for the top-left cell to the bottom-right cell.

Let's focus on two important things:
We want to find a path between two cells.
We want to minimize some obejective.
Dijkstra's Algorithm
It looks something that Dijkstra's Algorithm can solve !

But what is DIJKSTRA ?!!
Dijkstra's Algorithm is an algorithm to find the shortest path between two nodes in a graph or two cells in a matrix like our problem.
It's part of a family of algorithms designed to uncover the shortest path between nodes or cells like BFS, Bellman-Ford Algorithm, Floyd-Warsahll Algorithm. Each algorithm has its unique applications.

Let's focus on Dijkstra's Algorithm:
Nature: It's a single-source, multiple-destination algorithm. In simpler terms, it pinpoints the shortest path from a starting node to any other node in our graph.
Constraints: Dijkstra's Algorithm is suitable for graphs or problems featuring positive weights. If we encounter negative weights, we'd choose alternative algorithms such as Bellman-Ford.
And there you have it! Dijkstra's Algorithm is the key to our problem, well-known for tackling precisely these types of challenges.

Binary Search
Another interesting approach to solve this problem is to use binary search. But how? What if we shift our perspective a bit?

I put it in this post because I found it a unique solution to a problem that we can solve using Dijkstra's Algorithm.

Instead of focusing solely on finding the shortest path between the starting and ending cells, let's consider traversing the entire matrix. We can approach this much like a DFS (Depth-First Search) like any other simple problem.

Picture this: As we navigate through the matrix using DFS, we're mindful of this effort limit. The goal? To reach the end cell while ensuring that our maximum effort remains below this specified limit.

Now, here comes the interesting part—let's integrate binary search into this. We'll perform a binary search around this limit effort in our DFS traversal. By doing so, we can effectively hone in on the optimal effort threshold that guarantees our success in reaching the end cell. If we achieve this within the defined effort threshold, it indicates a possibility to reach the goal cell with an even lower effort.

In essence, this creative approach combines the power of binary search with DFS, enriching our problem-solving repertoire.

Proposed Approaches
Dijkstra's Algorithm
Steps
Create a 2D effort array and define directional changes using dx and dy.
Initialize cell efforts to maximum value.
Call dijkstra to find the minimum effort.
Initialize a priority queue to store (-effort, {x, y}) to make it return the minimum element.
Push the top-left cell into the queue with initial effort as 0.
While the priority queue is not empty:
Pop the cell with the least effort.
If cost is greater than existing effort, skip.
If at bottom-right cell, return minimum effort.
Explore four directions, update efforts, and push to queue if lower effort found.
Return the minimum effort from top-left to bottom-right cell.
Complexity
Time complexity:O(M∗N∗log(M∗N))O(M * N * log(M * N))O(M∗N∗log(M∗N))
The time complexity for Dijkstra's Algorithm is O(E * log(E)), where E is the number of edges in the graph. In our case, we can consider the number of edges are M * N.
Space complexity:O(M∗N)O(M * N)O(M∗N)
Since we are storing the minimum effort for the path from the starting point to each cell, then the space complexity is O(M * N).
Binary Search
Steps
Create a 2D array visited to track visited cells and define directional changes using dx and dy.
Set the lower and upper limits for binary search.
Perform binary search to find the minimum effort needed:
Use DFS to traverse the matrix within the effort limits.
Update the search range accordingly based on DFS results.
Depth-First Search (DFS) Function:
Mark the current cell as visited.
Stop if the bottom-right cell is reached.
Explore each direction (up, down, left, right):
Check if the new coordinates are within bounds.
Move to the next cell if the effort is within the specified limit.
Return minimum effort
Complexity
Time complexity:O(M∗N∗log(106))O(M * N * log(10^6))O(M∗N∗log(10 
6
 ))
The time complexity for Binary Search is log(upper_bound - lower_bound) and in our case the maximum range in 10^6. and since we are doing DFS in each iteration knowing that the time complexity for the single DFS is O(N * M) then the total time complexity is O(M * N * log(10^6)).
Space complexity:O(M∗N)O(M * N)O(M∗N)
Since we are storing the visited array for each cell and the DFS recursion stack complexity is also O(M * N), then the space complexity is O(M * N).
class Solution {
    private int[][] effort = new int[105][105];  // Store effort for each cell
    private int[] dx = {0, 1, -1, 0};  // Changes in x coordinate for each direction
    private int[] dy = {1, 0, 0, -1};  // Changes in y coordinate for each direction

    // Dijkstra's Algorithm to find minimum effort
    private int dijkstra(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        // Priority queue to store {effort, {x, y}}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(-a[0], -b[0]));
        pq.add(new int[]{0, 0, 0});  // Start from the top-left cell
        effort[0][0] = 0;  // Initial effort at the starting cell

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int cost = -current[0];  // Effort for the current cell

            int x = current[1];
            int y = current[2];

            // Skip if we've already found a better effort for this cell
            if (cost > effort[x][y])
                continue;

            // Stop if we've reached the bottom-right cell
            if (x == rows - 1 && y == cols - 1)
                return cost;

            // Explore each direction (up, down, left, right)
            for (int i = 0; i < 4; i++) {
                int new_x = x + dx[i];
                int new_y = y + dy[i];

                // Check if the new coordinates are within bounds
                if (new_x < 0 || new_x >= rows || new_y < 0 || new_y >= cols)
                    continue;

                // Calculate new effort for the neighboring cell
                int new_effort = Math.max(effort[x][y], Math.abs(heights[x][y] - heights[new_x][new_y]));

                // Update effort if a lower effort is found for the neighboring cell
                if (new_effort < effort[new_x][new_y]) {
                    effort[new_x][new_y] = new_effort;
                    pq.add(new int[]{-new_effort, new_x, new_y});
                }
            }
        }
        return effort[rows - 1][cols - 1];  // Minimum effort for the path to the bottom-right cell
    }

    // Function to find the minimum effort path
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        // Initialize effort for each cell to maximum value
        for (int i = 0; i < rows; i++) {
            Arrays.fill(effort[i], Integer.MAX_VALUE);
        }

        return dijkstra(heights);  // Find minimum effort using dijkstra
    }
}
*/

class Solution {
    private boolean[][] visited;  // Visited cells tracker
    private int[] directions_x = {0, 1, -1, 0};  // Changes in x coordinate for four directions
    private int[] directions_y = {1, 0, 0, -1};  // Changes in y coordinate for four directions
    private int numRows, numCols;  // Number of rows and columns in the matrix

    // Depth-First Search to explore the path with a given limit effort
    private void dfs(int x, int y, int limitEffort, int[][] heights) {
        if (visited[x][y])
            return;
        visited[x][y] = true;

        // Stop if we've reached the bottom-right cell
        if (x == numRows - 1 && y == numCols - 1)
            return;

        // Explore each direction (up, down, left, right)
        for (int i = 0; i < 4; i++) {
            int new_x = x + directions_x[i];
            int new_y = y + directions_y[i];

            // Check if the new coordinates are within bounds
            if (new_x < 0 || new_x >= numRows || new_y < 0 || new_y >= numCols)
                continue;

            // Go to next cell if the effort is within limit
            int newEffort = Math.abs(heights[x][y] - heights[new_x][new_y]);
            if (newEffort <= limitEffort)
                dfs(new_x, new_y, limitEffort, heights);
        }
    }

    public int minimumEffortPath(int[][] heights) {
        numRows = heights.length;
        numCols = heights[0].length;

        // Initialize visited array
        visited = new boolean[numRows][numCols];

        // Bound for our binary search
        int lowerLimit = 0, upperLimit = 1_000_000;

        while (lowerLimit < upperLimit) {
            int mid = (upperLimit + lowerLimit) / 2;
            for (boolean[] row : visited) {
                Arrays.fill(row, false);
            }

            dfs(0, 0, mid, heights);

            if (visited[numRows - 1][numCols - 1])
                upperLimit = mid;
            else
                lowerLimit = mid + 1;
        }

        return lowerLimit;
    }
}