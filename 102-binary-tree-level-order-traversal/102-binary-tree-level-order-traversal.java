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
    List<List<Integer>> answer = new ArrayList<List<Integer>>();

    public void levelHelper(TreeNode node, int level) {
        // start the current level
        if (answer.size() == level) {
            answer.add(new ArrayList<Integer>());
        }

         // fulfil the current level
         answer.get(level).add(node.val);

         // process child nodes for the next level
         if (node.left != null) {
            levelHelper(node.left, level + 1);
         }
         if (node.right != null) {
            ;levelHelper(node.right, level + 1);
         }
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) { return answer; }
        levelHelper(root, 0);
        return answer;
    }
}