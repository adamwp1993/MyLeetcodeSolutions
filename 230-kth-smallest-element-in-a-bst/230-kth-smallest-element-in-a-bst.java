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
    int answer;
    int count = 0;
    
    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return answer;
    }
    
    //DFS inorder traversal - left, root, right
    // bottom up
    public void traverse(TreeNode root, int k) {
        // base case 
        if(answer != 0) return;
        
        // traverse left subtree 
        if(root.left != null) {
            traverse(root.left, k);
        }
        // root 
        count++;
        if(count == k) {
            answer = root.val;
        }
        // right subtree
        if(root.right != null) {
            traverse(root.right, k);
        }
        
        return;
    }
}