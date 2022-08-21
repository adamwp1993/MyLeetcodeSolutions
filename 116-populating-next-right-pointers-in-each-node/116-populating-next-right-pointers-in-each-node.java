/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        
        // queue of lists, each list is all nodes on a level of the tree
        Queue<List<Node>> q = new LinkedList<>();
        List<Node> level = new ArrayList<>();
        level.add(root);
        q.add(level);
        
        while(!q.isEmpty()) {
            List<Node> curLevel = q.poll();
            List<Node> nextLevel = new ArrayList<>();
            for(int i = 0; i < curLevel.size(); i++) {
                Node curNode = curLevel.get(i);
                // if last node on the right, next pointer is null 
                if(i == curLevel.size() - 1) {
                    curNode.next = null;
                }
                else {
                    curNode.next = curLevel.get(i + 1);
                }
                // add children to next level
                if(curNode.left != null) {
                    nextLevel.add(curNode.left);
                }
                if(curNode.right != null) {
                    nextLevel.add(curNode.right);
                }
            }
            // add next level to queue if not empty 
            if(nextLevel.size() > 0) {
                q.add(nextLevel);
            }
        }
        
        return root;
    }
}