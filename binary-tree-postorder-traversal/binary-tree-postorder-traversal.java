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
    
    public List<Integer> postorderTraversal(TreeNode root) {
        // recursive solution 
        // PostOrder - left subtree, right subtree, root
        if(root == null) {
            return values;
        }
        
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        values.add(root.val);
        
        return values;
        
    }
}