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
    public int goodNodes(TreeNode root) {
        return traverse(root, Integer.MIN_VALUE);
    }
    
    public int traverse(TreeNode root, int max) {
        // DFS pre-order bottom up 
        if(root == null) return 0;
        // calculate count from each node then return it up. 
        int count = 0;
        // if current node has larger value, update to below nodes
        if(root.val > max) {
            max = root.val;
        }
        count += traverse(root.left, max);
        count += traverse(root.right, max);
        
        // increment count if its a "good" node 
        if(root.val >= max) {
            count++;
        }
        return count;
        
        
        
    }
}