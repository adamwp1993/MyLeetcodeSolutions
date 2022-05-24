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
        
        List<Integer> vals = new ArrayList<Integer>();
        // add all vals in order to arrayList
        // then we use two pointers to find if a sum exists 
        traverse(root, vals);
        int left = 0;
        int right = vals.size() - 1;
    
        while(left < right) {
            int sum = vals.get(left) + vals.get(right);
            if( sum == k) return true;
            if(sum < k) left++;
            if(sum > k) right--;
        }
        
        return false;
        
    }
    
    public void traverse(TreeNode root, List<Integer> vals) {
        // inorder DFS 
        // left, root, right
        if(root == null) return;
        traverse(root.left, vals);
        vals.add(root.val);
        traverse(root.right, vals);
        return;
    }
    
}