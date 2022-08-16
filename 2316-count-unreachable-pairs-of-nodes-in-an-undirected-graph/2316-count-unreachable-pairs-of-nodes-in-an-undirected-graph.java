class Solution {
    
    
    List<List<Integer>> graph = new ArrayList<>();
    
    public long countPairs(int n, int[][] edges) {
        
        // populate edges into graph
       
        for(int i = 0; i < n; i++) 
            graph.add(new ArrayList<>());
        for(int [] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        

        // run dfs 
        long unConnected = 0, sum = n;
        
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                int nodeCount = dfs( visited, i, new int[1]);
                sum = sum-nodeCount;
                unConnected += nodeCount * sum;
            }  
        }
        
        return unConnected;
        
    }
    
    public int dfs( boolean[] visited, int node, int[] count) {
        
        if(visited[node]) return count[0];
        visited[node] = true;
        count[0]++;
        
        // count current node and mark as visited
        
        
        
        for(int neighbor :  graph.get(node)) {
            dfs( visited, neighbor, count);
        }
        
        return count[0];
        
    }
    /*
        List<List<Integer>> graph = new ArrayList<>();
    public long countPairs(int n, int[][] edges) {
        for(int i=0; i<n; i++)
            graph.add(new ArrayList<>());
        for(int [] edge : edges){
            graph.get(edge[0]).add(edge[1]);  // make graph
            graph.get(edge[1]).add(edge[0]);
        }

        long res = 0, sum = n;
        boolean[] visited = new boolean[n];
        for(int i=0; i<n; i++)
            if(!visited[i]){
                int curr = dfs(i, visited, new int[1]); // find size of connected component
                sum = sum-curr;
                res += curr*sum;
            }
        return res;
    }

    int dfs(int node, boolean[] visited, int[] count){ 
        if(visited[node]) return count[0];
        visited[node] = true;
        count[0]++;
        for(int curr : graph.get(node))
            dfs(curr, visited, count);
        return count[0];
    }
    */
}