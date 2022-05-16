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
    public boolean isBalanced = true;
    
    // DFS pre-order 
    // O(N)
    
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        getDepth(root);
        
        return isBalanced;
    }
    public int getDepth(TreeNode root) {
        // returns the depth, starting from this node for left and right subtrees. 
        if(root == null || !isBalanced ) return 0;
        
        
        // find depth of left and right subtrees from current node 
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        // if the difference is greater than one, update isBalanced
        if(Math.abs(leftDepth - rightDepth) > 1) {
            isBalanced = false;
        }
        // return the largest depth
        return Math.max(leftDepth, rightDepth) + 1;
    }
}