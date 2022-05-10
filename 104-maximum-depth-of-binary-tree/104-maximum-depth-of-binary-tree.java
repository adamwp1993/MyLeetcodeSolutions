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
    public int maxDepth = 0;
    
    public int helper(TreeNode root, int depth) {
        if(root == null) { return maxDepth; }
        
        depth++;
        // determine if it is the deepest node 
        if(depth > maxDepth) {
            maxDepth = depth;
        }
        
        // process child nodes 
        helper(root.left, depth);
        helper(root.right, depth);
        return maxDepth;
    }
    
    //DFS Pre-Order traversal 
    public int maxDepth(TreeNode root) {
        
        helper(root, 0);
        
        return maxDepth;
        
    }
}