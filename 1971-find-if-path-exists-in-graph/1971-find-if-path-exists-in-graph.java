class Solution {
    // Can be solved with both a disjoint set AND with a DFS! 
    // We will be using both for this because its good practice :)
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // Code to solve with disjoint set
        /*
        UnionFind disjointSet = new UnionFind(n);
        for(int i = 0; i < edges.length; i++) {
            disjointSet.union(edges[i][0], edges[i][1]);
        }
        // if theyre connected a path exists 
        return disjointSet.connected(source, destination);
        */
        
        // DFS 
        // Create Adjacency list 
        List<List<Integer>> adjacent = new ArrayList<>();
        // add empty lists 
        for(int i = 0; i < n; i++) {
            adjacent.add(new ArrayList<Integer>());
        }
        
        // Add all edges
        for(int[] edge : edges) {
            // here we do both since its undirected 
            adjacent.get(edge[0]).add(edge[1]);
            adjacent.get(edge[1]).add(edge[0]);
        }
        
        // Create our stack 
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(source);
        // create array to hold seen nodes 
        boolean[] seen = new boolean[n];
        // fill array 
        Arrays.fill(seen, false);
        
        while(!stack.isEmpty()) {
            // get current node 
            int curNode = stack.pop();
            // check if we have reached target 
            if(curNode == destination) {
                return true;
            }

            // check if seen already. if we have, no need to continue pathfinding. 
            if(seen[curNode]) {
                continue;
            }

            // if not, set it to seen 
            seen[curNode] = true;

            // add neighbors to stack 
            for(int neighbor : adjacent.get(curNode)) {
                stack.push(neighbor);
            }
        }
        return false;  
        
    }
    
    // Disjoint set w/ union by rank and path compression 
    class UnionFind {
        private int[] root;
        private int[] rank;
        
        public UnionFind(int size) {
            root = new int[size];
            rank = new int[size];
            for(int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }
        
        public int find(int x) {
            if(root[x] == x) {
                return x;
            }
            return root[x] = find(root[x]);
        }
        
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if(rootX != rootY) {
                if(rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                }
                else if(rank[rootY] > rank[rootX]) {
                    root[rootX] = rootY;
                }
                else {
                    root[rootY] = rootX;
                    rank[rootX] += 1;
                }
            }
        }
        
        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
        
    }
}