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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        
        TreeNode root = bst(nums, 0, nums.length - 1);
        return root;
    }
    
    public TreeNode bst(int[] nums, int startIndex, int endIndex) {
        if(startIndex > endIndex || startIndex < 0 || endIndex >= nums.length) return null;
        
        int index = (startIndex + endIndex) / 2;
        TreeNode newNode = new TreeNode(nums[index]);
        newNode.left = bst(nums, startIndex, index - 1);
        newNode.right = bst(nums, index + 1, endIndex);
        
        return newNode;
    }

}