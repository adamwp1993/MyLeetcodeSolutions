class Solution {
    // Algorithm:
    // use a disjoint set 
    // Populate all unions
    // the number of root nodes = the number of provinces. count the root nodes and return. 
    int[] rank;
    int[] root;
    
    // build the disjoint set 
    public void buildSet(int size) {
        root = new int[size];
        rank = new int[size];
        for(int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }
    // helper functions for disjoint sets 
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
    
    public int findCircleNum(int[][] isConnected) {
        // build disjoint set 
        int nodes = isConnected.length;
        int provinces = 0;
        buildSet(nodes);
        // create unions
        for(int i = 0; i < nodes; i++) {
            for(int j = 0; j < nodes; j++) {
                if(isConnected[i][j] == 1) {
                    union(i,j);
                }
            }
        }
        // count the number of roots 
        for(int n = 0; n < nodes; n++) {
            if(n == find(n)) {
                provinces += 1;
            }
        }
        return provinces;
        
    }
}