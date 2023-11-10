class Solution {
    Map<Integer, List<Integer>> graph;
    public int[] restoreArray(int[][] adjacentPairs) {
        if(adjacentPairs.length == 1) 
            return adjacentPairs[0];
        graph = new HashMap<>();
        for(int[] edge : adjacentPairs) {
            int x = edge[0];
            int y = edge[1];
            if(!graph.containsKey(x)) {
                graph.put(x, new ArrayList<>());
            }
            if(!graph.containsKey(y)) {
                graph.put(y, new ArrayList<>());
            }
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        int root = 0;
        for(int num : graph.keySet()) {
            if(graph.get(num).size() == 1) {
                root = num;
                break;
            }
        }
        int[] result = new int[adjacentPairs.length + 1];
        dfs(root, Integer.MAX_VALUE, result, 0);
        return result;
    }
    private void dfs(int node, int prev, int[] ans, int i) {
        ans[i] = node;
        for (int neighbor : graph.get(node)) {
            if (neighbor != prev) {
                dfs(neighbor, node, ans, i + 1);
            }
        }
    }
}