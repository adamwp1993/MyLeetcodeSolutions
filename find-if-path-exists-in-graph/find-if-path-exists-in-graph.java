class Solution {
    // Can be solved with both a disjoint set AND with a DFS! 
    // We will be using both for this because its good practice :)
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // Solve with disjoint set
        UnionFind disjointSet = new UnionFind(n);
        for(int i = 0; i < edges.length; i++) {
            disjointSet.union(edges[i][0], edges[i][1]);
        }
        // if theyre connected a path exists 
        return disjointSet.connected(source, destination);
        
        
        
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