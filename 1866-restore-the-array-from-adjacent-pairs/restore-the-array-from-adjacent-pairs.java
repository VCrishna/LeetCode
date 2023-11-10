class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        // If there is only one pair, return it
        if (adjacentPairs.length == 1) return adjacentPairs[0];

        // Create a graph to represent the adjacent pairs
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : adjacentPairs) {
            int x = edge[0];
            int y = edge[1];

            // If x is not in the graph, add it with an empty list
            if (!graph.containsKey(x)) {
                graph.put(x, new ArrayList<>());
            }
            // If y is not in the graph, add it with an empty list
            if (!graph.containsKey(y)) {
                graph.put(y, new ArrayList<>());
            }

            // Add y to the neighbors of x, and add x to the neighbors of y
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        // Find the root of the tree by identifying the node with only one neighbor
        int root = 0;
        for (int num : graph.keySet()) {
            if (graph.get(num).size() == 1) {
                root = num;
                break;
            }
        }

        // Initialize the result array
        int[] result = new int[adjacentPairs.length + 1];

        // Perform depth-first search to construct the result array
        dfs(graph, root, Integer.MAX_VALUE, result, 0);

        // Return the result array
        return result;
    }
    // Depth-first search function to traverse the graph and construct the result array
    private void dfs(Map<Integer, List<Integer>> graph, int node, int prev, int[] ans, int i) {
        ans[i] = node;

        // Iterate through neighbors of the current node
        for (int neighbor : graph.get(node)) {
            // If the neighbor is not the previous node, perform DFS on the neighbor
            if (neighbor != prev) {
                dfs(graph, neighbor, node, ans, i + 1);
            }
        }
    }
}
