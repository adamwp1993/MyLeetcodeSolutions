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
    
    
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> largest = new ArrayList<Integer>();
        if(root == null) return largest;
        
        traverse(root, largest, 0);
        
        return largest;
    }
    
    public void traverse(TreeNode root, List<Integer> largest, int level) {
        // level order traversal
        
        
        // check if value is highest for this level 
        if(largest.size() == level) {
            largest.add(root.val);
        }
        else if(largest.get(level) < root.val) {
            largest.set(level, root.val);
        }
        // traverse subtrees recursively 
        if(root.left != null) {
            traverse(root.left, largest, level + 1);
        }
        if(root.right != null) {
            traverse(root.right, largest, level +1);
        }
        return;
    }
}