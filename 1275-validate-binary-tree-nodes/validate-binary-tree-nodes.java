public class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        
        // Step 2: Identify children and set parent
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                if (parent[leftChild[i]] != -1) return false;  // node has two parents
                parent[leftChild[i]] = i;
            }
            
            if (rightChild[i] != -1) {
                if (parent[rightChild[i]] != -1) return false;  // node has two parents
                parent[rightChild[i]] = i;
            }
        }
        
        // Find root (node that isn't a child)
        int rootCount = 0, root = -1;
        for (int i = 0; i < n; i++) {
            if (parent[i] == -1) {
                rootCount++;
                root = i;
            }
        }
        if (rootCount != 1) return false;  // There should be exactly one root
        
        // Step 3: DFS to check for cycles and connectivity
        Set<Integer> visited = new HashSet<>();
        dfs(root, visited, leftChild, rightChild);
        
        // Step 4: Check if it's a single tree
        return visited.size() == n;
    }
    
    private void dfs(int node, Set<Integer> visited, int[] leftChild, int[] rightChild) {
        if (node == -1 || visited.contains(node)) return;
        visited.add(node);
        dfs(leftChild[node], visited, leftChild, rightChild);
        dfs(rightChild[node], visited, leftChild, rightChild);
    }
}
