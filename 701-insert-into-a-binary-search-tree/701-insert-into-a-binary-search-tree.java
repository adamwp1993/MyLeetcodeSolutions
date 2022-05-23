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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) {
            return new TreeNode(val);
        }
        traverse(root, val);
        return root;
    }
    
    public void traverse(TreeNode root, int val) {
        
        
        
        // BST navigation, left subtrees are less than, right greater than
        if(val < root.val && root.left != null) {
            traverse(root.left, val);
        }
        else if(val < root.val && root.left == null) {
            root.left = new TreeNode(val);
            return;
        }
        else if(val > root.val && root.right != null) {
            traverse(root.right, val);
        }
        else if(val > root.val && root.right == null) {
            root.right = new TreeNode(val);
            return;
        }
        
    }
}