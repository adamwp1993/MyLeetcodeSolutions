class Solution {
    public int earliestAcq(int[][] logs, int n) {
        
        // sort by timestamp 
        Arrays.sort(logs, (a, b) -> Integer.compare(a[0], b[0]));
        
        UnionFind set = new UnionFind(n);
        // build unions 
        for(int i = 0; i < logs.length; i++) {
            int timestamp = logs[i][0];
            set.union(logs[i][1], logs[i][2]);
            if(set.getComponents() == 1) {
                return timestamp;
            }
            
        }
        return -1;
        
    }
    
    
    class UnionFind {
        // DisJoint Set using Path compression and Union by rank
        int rank[];
        int root[];
        int components;
        
        public UnionFind(int size) {
            rank = new int[size];
            root = new int[size];
            components = size;
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
                components--;
            }
        }
        
        public int getComponents() {
            return components;
        }
    }
}