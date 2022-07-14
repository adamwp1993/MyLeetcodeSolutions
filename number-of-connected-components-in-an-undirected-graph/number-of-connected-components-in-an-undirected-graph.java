class Solution {
    int rank[];
    int root[];
    // DISJOINT SET FUNCTIONS 
    public void buildSet(int size) {
        rank = new int[size];
        root = new int[size];
        for(int i = 0; i < size; i++) {
            rank[i] = 1;
            root[i] = i;
        }
    }
    
    public int find(int x) {
        if(x == root[x]) {
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
    
    public int countComponents(int n, int[][] edges) {
        // 1. build set 
        // 2. populate unions 
        // 3. count roots. number of roots = # of components 
        int count = 0;
        // build set
        buildSet(n);
        // populate union
        for(int i = 0; i < edges.length; i++) {
            union(edges[i][0], edges[i][1]);
        }
        // count roots
        for(int j = 0; j < n; j++) {
            if(j == find(j)) count++;
        }
        return count;
    }
}