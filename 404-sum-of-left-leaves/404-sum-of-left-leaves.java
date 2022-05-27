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
    public int sumOfLeftLeaves(TreeNode root) {
        int res = traverse(root, false);
        return res;
    }
    
    public int traverse(TreeNode root, boolean isLeftNode) {
        if(root == null) return 0;
        int sum = 0;
        
        if(root.left == null && root.right == null && isLeftNode) {
            sum = root.val;
        }
        sum += traverse(root.left, true);
        sum += traverse(root.right, false);
        return sum;
    }
}