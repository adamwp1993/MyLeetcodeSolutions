
class Solution {
    public int longestPath = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        // DFS 
        // longest path is where a root node and the sum of its longest left brand and right branch is maximized 
        traverse(root);
        return longestPath;
    }
    
    public int traverse(TreeNode root) {
        // find deepest path to left 
        // find deepest path to right 
        // evaluate if longer than longestDepth, if so, we update it 
        if(root == null) return 0;
        
        
        
        // pre-order 
        // Calculate depth of left and right subtrees of this node
        int leftDepth = traverse(root.left);
        int rightDepth = traverse(root.right);
        
        // if the left and right subtrees of this node sum to be the longest path we've encountered so far, update our longest path
        if(leftDepth + rightDepth > longestPath) {
            longestPath = leftDepth + rightDepth;
        }
        
        // return the max depth plus the edge above it to the function call that called this one. (return maximum depth to node above)
        return Math.max(leftDepth, rightDepth) + 1;
    }
}