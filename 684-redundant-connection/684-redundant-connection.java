class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        // one redudant edge exists that we need to find 
        // how do we know which edge is redundant? 
        // check the roots! a new edge should change the root of one of the nodes.
        // if no roots change, then we know the edge is redundant.
        int[] result = new int[2];
        int n = edges.length;
        UnionFind disjoint = new UnionFind(n + 1);
        
        for(int i = 0; i < n; i++) {
            
            int oldRootX = edges[i][0];
            int oldRootY = edges[i][1];
            // if theyre already connected, then we know the edge we are about to attempt to insert is redundant and creates a cycle
            if(disjoint.connected(edges[i][0], edges[i][1])) {
                result[0] = edges[i][0];
                result[1] = edges[i][1];
            }
            disjoint.union(edges[i][0], edges[i][1]);
           
        }
        return result;
        
    }
    
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