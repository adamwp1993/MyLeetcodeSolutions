class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        
        List<List<Integer>> levels = new ArrayList<>();
        if(root == null) return levels;
        
        // prep BFS
        Queue<List<Node>> q = new LinkedList<>();
        List<Node> rootList = new ArrayList<>();
        rootList.add(root);
        q.add(rootList);
        
        // BFS
        while(!q.isEmpty()) {
            List<Node> curLevel = q.poll();
            List<Integer> vals = new ArrayList<>();
            List<Node> nextLevel = new ArrayList<>();
            // for each node in the level, add its children to nextLevel and add its value to the result 
            for(Node node : curLevel) {
                vals.add(node.val);
                for(Node child : node.children) {
                    nextLevel.add(child);
                }
            }
            if(nextLevel.size() > 0) {
                q.add(nextLevel);
            }
        
            levels.add(vals);
        }
        return levels;
    }
}