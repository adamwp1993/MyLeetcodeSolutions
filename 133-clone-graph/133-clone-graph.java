/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node, Node> map = new HashMap<>();
    
    
    public Node cloneGraph(Node node) {
        // handle edge case
        if(node == null) return null;
    
        
        return dfs(node);
    
    
        
    }
    
    public Node dfs(Node node) {
        // if new node already exists in hashmap just return it
        if(map.containsKey(node)) {
            return map.get(node);
        }
        
        // copy node and update hashmap
        Node newNode = new Node(node.val);
        // update hashmap
        map.put(node, newNode);
        // if neighbor doesnt exist, create it. then we add neighbor to the adjacency list 
        for(Node neighbor : node.neighbors) {
            newNode.neighbors.add(dfs(neighbor));
        }
        
        return newNode;
    }
}