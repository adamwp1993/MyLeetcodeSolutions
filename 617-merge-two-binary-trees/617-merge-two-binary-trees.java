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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // DFS pre order 
        // root, left, right 
        
        // if the value is null, we overwrite with the one that is not empty in the right or left value of node above this one 
        if( root1 == null ) return root2;
        if( root2 == null ) return root1;
        // sum the values if we can 
        root1.val += root2.val;
        // recursively assign subnode values 
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        
        return root1;
    }
    
}