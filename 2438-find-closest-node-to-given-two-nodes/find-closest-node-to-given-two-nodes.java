class Solution {

    // DFS to compute distances from the given starting node
    public void dfs(int node, int[] edges, int[] distance, boolean[] visited) {
        visited[node] = true;
        int neighbor = edges[node];

        // If there is a valid neighbor and it hasn't been visited
        if (neighbor != -1 && !visited[neighbor]) {
            distance[neighbor] = distance[node] + 1; // Update distance
            dfs(neighbor, edges, distance, visited); // Recurse
        }
    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int ans = -1;
        int minDist = Integer.MAX_VALUE;

        int[] dist1 = new int[n];          // Distance array from node1
        int[] dist2 = new int[n];          // Distance array from node2
        boolean[] visited1 = new boolean[n]; // Visited array for DFS from node1
        boolean[] visited2 = new boolean[n]; // Visited array for DFS from node2

        // Fill distance and visited info via DFS from both nodes
        dfs(node1, edges, dist1, visited1);
        dfs(node2, edges, dist2, visited2);

        // Try each node and find the best meeting point
        for (int currNode = 0; currNode < n; currNode++) {
            // Must be reachable from both node1 and node2
            if (visited1[currNode] && visited2[currNode]) {
                int maxDist = Math.max(dist1[currNode], dist2[currNode]);

                // Check if this node gives a better minimum of max distances
                if (minDist > maxDist) {
                    minDist = maxDist;
                    ans = currNode;
                }
            }
        }

        return ans;
    }
}
