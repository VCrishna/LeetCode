/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    
    public int amountOfTime(TreeNode root, int start) {
        // Creating an adjacency list to represent the graph
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

        // Converting the binary tree to an undirected graph
        convertToGraph(root, adjacencyList);

        // Initializing a queue for BFS traversal, a set for visited nodes, and time variable
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        Set<Integer> visited = new HashSet<>();
        int time = -1;

        // BFS traversal
        while (!queue.isEmpty()) {
            
            time++;
            for (int i = queue.size(); i > 0; i--) {
                
                int currentNode = queue.pollFirst();
                visited.add(currentNode);
                // Explore neighbors of the current node in the graph
                if (adjacencyList.containsKey(currentNode)) {
                    for (int neighbor : adjacencyList.get(currentNode)) {
                        if (!visited.contains(neighbor)) {
                            queue.offer(neighbor);
                        }
                    }
                }
            }
        }
        return time;
    }

    // Method to convert the binary tree to an undirected graph represented by an adjacency list using DFS traversal
    public void convertToGraph(TreeNode root, Map<Integer, List<Integer>> adjacencyList) {
        if (root == null) {
            return;
        }

        // Adding edges between the current node and its left and right children
        if (root.left != null) {
            adjacencyList.computeIfAbsent(root.val, k -> new ArrayList<>()).add(root.left.val);
            adjacencyList.computeIfAbsent(root.left.val, k -> new ArrayList<>()).add(root.val);
        }
        if (root.right != null) {
            adjacencyList.computeIfAbsent(root.val, k -> new ArrayList<>()).add(root.right.val);
            adjacencyList.computeIfAbsent(root.right.val, k -> new ArrayList<>()).add(root.val);
        }

        // Recursively convert left and right subtrees
        convertToGraph(root.left, adjacencyList);
        convertToGraph(root.right, adjacencyList);
    }

    private int ans;

    public int amountOfTime_DIFFERENT_METHOD(TreeNode root, int start) {
        dfs(root, start);
        return ans;
    }

    public int dfs(TreeNode root, int start) {
        if (root == null)
            return 0;

        int leftDepth = dfs(root.left, start);
        int rightDepth = dfs(root.right, start);

        if (root.val == start) {
            ans = Math.max(leftDepth, rightDepth);
            return -1;
        } else if (leftDepth >= 0 && rightDepth >= 0) {
            return Math.max(leftDepth, rightDepth) + 1;
        } else {
            ans = Math.max(ans, Math.abs(leftDepth - rightDepth));
            return Math.min(leftDepth, rightDepth) - 1;
        }
    }

}