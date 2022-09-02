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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averages = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            long sum = 0;
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode current = q.poll();
                // add the vals from the level to the sum 
                sum += current.val;
                // add children to the queue 
                if(current.left != null) {
                    q.add(current.left);
                }
                if(current.right != null) {
                    q.add(current.right);
                }
                
            }
            // find the average for that level and add it to the result 
            double avg = (double)sum / size;
            averages.add(avg);
        }
        return averages;
    }
}