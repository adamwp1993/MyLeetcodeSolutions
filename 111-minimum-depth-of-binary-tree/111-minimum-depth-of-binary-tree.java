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
    public int min = 2147483647;
    
    
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        traverse(root, 0);
        return min;
    }
    
    public void traverse(TreeNode root, int depth) {
        if(root == null) return;
        depth++;
        
        // if we are on a leaf node evaluate the depth 
        if(root.left == null && root.right == null && depth < min) {
            min = depth;
        }
        
        traverse(root.left, depth);
        traverse(root.right, depth);
        
    }
}