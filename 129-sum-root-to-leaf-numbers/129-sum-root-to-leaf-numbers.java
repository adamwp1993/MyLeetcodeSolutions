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
    ArrayList<Integer> vals = new ArrayList<Integer>();
    
    public int sumNumbers(TreeNode root) {
        traverse(root, "");
        
        int sum = 0;
        for(int i = 0; i < vals.size(); i++) {
            sum += vals.get(i);
        }
        return sum;
    }
    
    public void traverse(TreeNode root, String path) {
        // update the path string which we will parse to int later when we reach the leaf 
        if(root == null) return;
        
        path += "" + root.val;
        
        // if its a leaf node, parse it, add it to vals
        if(root.right == null && root.left == null) {
            vals.add(Integer.parseInt(path));
            
        }
        // traverse 
        if(root.left != null) traverse(root.left, path);
        if(root.right != null) traverse(root.right, path);
        return;
        
    }
}