class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        // Create a set to store nodes that have parents.
        Set<Integer> hasParent = new HashSet<>();

        // Populating hasParent set with nodes from leftChild.
        for (int i : leftChild) {
            if (i != -1) hasParent.add(i);
        }
        // Populating hasParent set with nodes from rightChild.
        for (int i : rightChild) {
            if (i != -1) hasParent.add(i);
        }
        // Both above loops aim to find all nodes that are not roots.
        // adding left and right child's nodes into the set to remove duplicated

        // finding parent node
        // Initialize root to an invalid value (-1). We will try to identify the root node next.
        int root = -1;
        for (int i = 0; i < n; i++) {
            // Iterating through all nodes.
            if (!hasParent.contains(i)) {
                // If a node does not have a parent, it's the root.
                // Update the root's value.
                root = i;
                // Exit the loop once the root is found.
                break;
            }
        }

        // set used to keep track of visited nodes
        // Creating a set to store all visited nodes. This helps in detecting cycles.
        Set<Integer> visited = new HashSet<>();
        // calling dfs to find if these nodes are connected and they is no cycle exists in between these nodes
        // also if all node are connected the visited hashset size will be equal to given n
        // Also ensure all nodes are visited.
        return dfs(root, leftChild, rightChild, visited) && visited.size() == n;
    }

    // Recursive DFS function to traverse the tree.
    public boolean dfs(int node, int[] leftChild, int[] rightChild, Set<Integer> visited) {
        // Base case: If node is -1 (i.e., a null reference), just return true.
        if (node == -1) {
            return true;
        }
        // If the current node was already visited, it means there's a cycle.
        if (visited.contains(node)) {
            return false;
        }
        // Mark the current node as visited.
        visited.add(node);
        // Recursively traverse the left and right subtrees.
        return dfs(leftChild[node], leftChild, rightChild, visited) && dfs(rightChild[node], leftChild, rightChild, visited);
    }
}
