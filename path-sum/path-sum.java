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
    public boolean pathSum = false;
    
    public boolean helper(TreeNode root, int currentSum, int targetSum) {
        if(root == null) {
            return false;
        }
        // root, left, right 
        // add the root value to the current sum 
        currentSum += root.val;
        // if current sum == target sum and its a leaf node
        if(currentSum == targetSum && root.left == null && root.right == null) {
            pathSum = true;
        }
        // recursively call 
        helper(root.left, currentSum, targetSum);
        helper(root.right, currentSum, targetSum);
        return false;
        
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // pre-order DFS 
        helper(root, 0, targetSum);
        
        return pathSum;
        
    }
}