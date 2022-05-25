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
    private List<List<Integer>> paths = new ArrayList<List<Integer>>();
    
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        traverse(root, targetSum, new ArrayList<Integer>(), 0);
        return paths;
    }
    
    public void traverse(TreeNode root, int targetSum, List<Integer> currentPath, int sum) {
        // pre-order DFS 
        if(root == null) return;
        
        sum += root.val;
        currentPath.add(root.val);
        if(root.left == null && root.right == null && sum == targetSum) {
            paths.add(currentPath);
            return;
        }
        traverse(root.left, targetSum, new ArrayList<Integer>(currentPath), sum);
        traverse(root.right, targetSum, new ArrayList<Integer>(currentPath), sum);
        
        return;
    }
}