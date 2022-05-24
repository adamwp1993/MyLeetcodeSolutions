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
    private ArrayList<Integer> possibleVals = new ArrayList<Integer>();
    
    
    public boolean findTarget(TreeNode root, int k) {
        
        return traverse(root, k);
    }
    
    public boolean traverse(TreeNode root, int k) {
        
        // pre-order top down DFS - root, left, right 
        
        // if a sum exists return true 
        if(checkVals(root.val, k)) return true;
        possibleVals.add(root.val);
        
        if( (root.left != null &&traverse(root.left, k)) || (root.right != null && traverse(root.right, k)))  return true;
        
        return false;
        
    }
    
    public boolean checkVals(int check, int k) {
        // checks if any value in possibleVals + the current value sum to k
        for(Integer i : possibleVals) {
            if(i + check == k) return true;
        }
        return false;
    }
}