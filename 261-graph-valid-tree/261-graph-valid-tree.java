class Solution {
    int rank[];
    int root[];
    // Disjoint set 
    public void buildSet(int size) {
        rank = new int[size];
        root = new int[size];
        for(int i = 0; i < size; i++) {
            rank[i] = 1;
            root[i] = i;
        }
    }
    // disjoint set union
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
    // disjoint set find
    public int find(int x) {
        if(x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);
    }
    public boolean validTree(int n, int[][] edges) {
        // 1. Create a Disjoint set. 
        // 2. if edges != n - 1, then its either not fully connected or has a cycle, return false.
        // 3. populate all unions.
        // 4. count roots. if more than one, not fully connected, return false. otherwise it must be fully connected and have no cycles so its valid.
        if(edges.length != n - 1) return false;
        
        // build set and edges 
        buildSet(n);
        for(int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            union(x, y);
        }
        // count roots
        int count = 0;
        for(int j = 0; j < n; j++) {
            if(find(j) == j) {
                count++;
                if(count > 1) return false;
            }
        }
        return true;
        
    }
}