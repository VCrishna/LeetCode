class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Set<Integer> hasParent = new HashSet<>();

        // adding left and right child's nodes into the set to remove duplicated
        for(int i : leftChild) {
            if(i != -1)
                hasParent.add(i);
        }
        for(int i : rightChild) {
            if(i != -1)
                hasParent.add(i);
        }

        // finding parent node
        int root = -1;
        for(int i = 0; i < n; i++) {
            if(!hasParent.contains(i)) {
                root = i;
                break;
            }
        }
        // set used to keep track of visited nodes
        Set<Integer> visited = new HashSet<>();
        // calling dfs to find if these nodes are connected and they is no cycle exists in between these nodes
        // also if all node are connected the visited hashset size will be equal to given n
        return dfs(root, leftChild, rightChild, visited) && visited.size() == n;
    }

    public boolean dfs(int node, int[] leftChild, int[] rightChild, Set<Integer> visited) {
        if(node == -1) {
            return true;
        }
        if(visited.contains(node)) {
            return false;
        }
        visited.add(node);
        return dfs(leftChild[node], leftChild, rightChild, visited) &&
               dfs(rightChild[node], leftChild, rightChild, visited);
    }
}