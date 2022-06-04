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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        while(root != null) {
            List<Integer> vals = new ArrayList<Integer>();
            root = traverse(root, vals);
            result.add(vals);
        }
        
        return result;
    }
    
    public TreeNode traverse(TreeNode root, List<Integer> vals) {
        // removes all leaf nodes and adds leafs vals to list 
        // DFS preorder 
        if(root == null) return null;
        
        
        if(root.left == null && root.right == null) {
            vals.add(root.val);
            return null;
        }
        
        root.left = traverse(root.left, vals);
        root.right = traverse(root.right, vals);
        
        
        return root;
    }
}