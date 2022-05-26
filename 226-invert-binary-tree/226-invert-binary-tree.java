
class Solution {
    public TreeNode invertTree(TreeNode root) {
        traverse(root);
        return root;
    }
    
    public void traverse(TreeNode root) {
        
        if(root == null) return;
        traverse(root.left);
        traverse(root.right);
        
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return;
    }
}