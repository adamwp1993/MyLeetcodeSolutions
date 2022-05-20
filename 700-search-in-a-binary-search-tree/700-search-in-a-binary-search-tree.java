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
    TreeNode result;
    
    public TreeNode searchBST(TreeNode root, int val) {
        
        // DFS inorder traversal 
        // left, root, right
        traverse(root, val);
        return result;
        
    }
    
    public TreeNode traverse(TreeNode root, int val) {
        if(root == null) {
            return null;
        }
        // Binary search tree - we dont have to visit all nodes 
        // determine direction based on if val is less or more than current nodes value. 
        if(val < root.val) {
            traverse(root.left, val);
        }
        
        if(root.val == val) {
            result = root;
        }
        if(val > root.val) {
            traverse(root.right, val);
        }
        return null;
    }
    
}