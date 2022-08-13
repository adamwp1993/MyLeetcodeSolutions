class Solution {
    
    public int countComponents(int n, int[][] edges) {
        // create graph / adjacency list 
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++) {
            int nodea = edges[i][0];
            int nodeb = edges[i][1];
            graph.get(nodea).add(nodeb);
            graph.get(nodeb).add(nodea);
        }
        
        boolean[] visited = new boolean[n];
        
        // run DFS from each node until all have been visited
        int count = 0;
        for(int p = 0; p < n; p++) {
            count += dfs(p, graph, visited);
        }
        return count;
        
    }
    
    public int dfs(int node, HashMap<Integer, List<Integer>> graph, boolean[] visited) {
        // if already visited return 0
        if(visited[node]) return 0;
        // mark node as visited
        visited[node] = true;
        // visit neighbor nodes recursively
        for(int neighbor : graph.get(node)) {
            dfs(neighbor, graph, visited);
        }
        return 1;
    }
        
}