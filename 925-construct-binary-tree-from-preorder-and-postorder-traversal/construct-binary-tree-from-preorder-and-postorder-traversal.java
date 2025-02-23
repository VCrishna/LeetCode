/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) 
    {
        // Step 1: Base Case
        if (preorder.length == 0)
        {
            return null; 
        } 
        
        return buildTree(preorder, postorder);
    }

    private TreeNode buildTree(int[] pre, int[] post)
    {
        // Step 2: If preorder is empty, return NULL
        if (pre.length == 0)
        {
            return null;
        } 

        // Step 3: The first element in preorder is always the root
        TreeNode root = new TreeNode(pre[0]);

        // Step 4: If there's only one element, return the single node
        if (pre.length == 1)
        {
            return root;
        } 

        // Step 5: The second element in preorder is the left child (if exists)
        int leftRootVal = pre[1];
        int leftSubtreeSize = 0;

        // Step 6: Find the left subtree size by locating leftRootVal in postorder
        for (int i = 0; i < post.length; i++)
        {
            if (post[i] == leftRootVal)
            {
                // Step 7: Left subtree elements count
                leftSubtreeSize = i + 1;
                break;
            }
        }

        // Step 8: Split preorder into left and right subtree elements
        int[] leftPre = Arrays.copyOfRange(pre, 1, leftSubtreeSize + 1);
        int[] rightPre = Arrays.copyOfRange(pre, leftSubtreeSize + 1, pre.length);

        // Step 9: Split postorder into left and right subtree elements
        int[] leftPost = Arrays.copyOfRange(post, 0, leftSubtreeSize);
        int[] rightPost = Arrays.copyOfRange(post, leftSubtreeSize, post.length - 1);

        // Step 10: Recursively build left and right subtrees
        root.left = buildTree(leftPre, leftPost);
        root.right = buildTree(rightPre, rightPost);

        // Step 11: Return the constructed root node
        return root;
    }
}