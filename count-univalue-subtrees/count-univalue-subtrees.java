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
    
    int count = 0;
    
    public boolean unival(TreeNode node) {
        // leaf nodes are technically a univalue subtree 
        if(node.left == null && node.right == null) {
            count++;
            return true;
        }
        
        boolean is_unival = true;
        
        // check if child nodes are unival and share the same value. 
        if(node.left != null) {
            is_unival = unival(node.left) && is_unival && node.left.val == node.val;
        }
        if(node.right != null) {
            is_unival = unival(node.right) && is_unival && node.right.val == node.val;
        }
        
        if(!is_unival) { return false; }
        else {
            count++;
            return true;
        }
        
    }
    public int countUnivalSubtrees(TreeNode root) {
        // DFS bottom up 
        if(root == null) { return 0; }
        unival(root);
        return count;
    }
}