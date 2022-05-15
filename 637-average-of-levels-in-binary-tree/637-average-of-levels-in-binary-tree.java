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
    public List<List<Integer>> levels = new ArrayList<List<Integer>>();
    
    // level order BFS traversal 
    // traverse the tree and create a 2D array of integers
    // then we will use that List to calculate averages. 
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averages = new ArrayList<Double>();
        
        if(root == null) return averages;
        
        traverse(root, 0); 
        // calculate averages 
        
        for(int i = 0; i < levels.size(); i++) {
            double sum = 0.0;
            for(int j = 0; j < levels.get(i).size(); j++) {
                sum += levels.get(i).get(j);
            }
            averages.add((Double)sum / levels.get(i).size());
            
        }
        
        return averages;
        
    }
    
    public void traverse(TreeNode node, int level) {
        // Add a level to the 2D list 
        if (levels.size() == level) {
            levels.add(new ArrayList<Integer>());
        }

         // add the root value
         levels.get(level).add(node.val);

         // recursively call for child nodes 
         if (node.left != null) {
            traverse(node.left, level + 1);
         }
         if (node.right != null) {
            traverse(node.right, level + 1);
         }
    }
}