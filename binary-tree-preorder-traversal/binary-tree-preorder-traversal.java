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
    // rescursive solution 
    public List<Integer> values = new ArrayList<>();
    
    public List<Integer> preorderTraversal(TreeNode root) {
        // if root is empty just return the emtpy list 
        if(root == null) { return values; }
        
        // pre-order traversal - root node, left subtree, then right subtree  
        values.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return values;
    }
}