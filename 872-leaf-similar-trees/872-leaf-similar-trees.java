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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        // DFS pre-order 
        // generate arrayLists of leaf vals 
        // loop through and if the lists dont match, return false. else return true. 
        
        ArrayList<Integer> vals1 = new ArrayList<Integer>();
        ArrayList<Integer> vals2 = new ArrayList<Integer>();
        
        traverse(vals1, root1);
        traverse(vals2, root2);
        
        if(vals1.size() != vals2.size()) return false;
        
        for(int i = 0; i < vals1.size(); i++) {
            if(vals1.get(i) != vals2.get(i)) return false;
        }
        
        return true;
    }
    
    public void traverse(ArrayList<Integer> vals, TreeNode root) {
        if(root == null) return;
        
        if(root.left == null && root.right == null) {
            vals.add(root.val);
        }
        
        traverse(vals, root.left);
        traverse(vals, root.right);
        
    }
}