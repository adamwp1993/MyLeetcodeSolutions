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
    public List<Integer> values = new ArrayList<Integer>();
    
    public List<Integer> inorderTraversal(TreeNode root) {
        // Recursive Solution
        // in order traversal - Left subtree, Root, then right subtree
        if(root == null) {
            return values;
        }
        inorderTraversal(root.left);
        values.add(root.val);
        inorderTraversal(root.right);
        
        return values;
        
        
    }
}