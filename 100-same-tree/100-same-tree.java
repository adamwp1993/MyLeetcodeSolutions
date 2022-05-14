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
    public boolean same = true;
    
    // pre-order DFS - root, left, right 
    // recusively navigate both trees at the same time 
    public boolean helper(TreeNode t1, TreeNode t2) {
        // handle null cases
        if(t1 == null & t2 == null) { return true; }
        if(t1 == null || t2 == null) { 
            same = false;
            return false; 
        }
        // eval if the values are the same. if they arent  
        if(t1.val != t2.val) {
            same = false;
            return false;
        }
        helper(t1.left, t2.left);
        helper(t1.right, t2.right);
        return true;
        
        
    }
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        helper(p, q);
        return same;
    }
}