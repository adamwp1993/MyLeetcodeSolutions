class Solution {
    class UnionFind {
        // how to do disjoint set with a 2D array? 
        // i * n + j where i = index of outer array, n = length of inner array, j = index of inner array returns the index in the root array
        int[] root;
        int[] rank;
        int count; // count holds the number of islands that currently exist 
        
        public UnionFind(int size) {
            count = 0;
            root = new int[size];
            rank = new int[size];
            for(int i = 0; i < size; i++) {
                root[i] = -1;
                rank[i] = 0;
            }
        }
        
        public boolean valid(int i) {
            return root[i] >= 0;
        }
        
        public void setRoot(int i) {
            if(root[i] == -1) {
                root[i] = i;
                // increase count of islands any time we add an unconnected component 
                ++count;
                }
        }
        
        public int find(int i) {
            if(root[i] == i) return i;
            return root[i] = find(root[i]);
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
                // decrement count of islands any time we join two unconnected components 
                count --;
            }
            
        }
        
        public int getCount() {
            return count;
        }
    }
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        UnionFind disjoint = new UnionFind(m * n);
        
        for(int[] current : positions) {
            int row = current[0];
            int col = current[1];
            
            // add the current position 
            int curIndex = row * n + col;
            disjoint.setRoot(curIndex);
            
            // check neighbors 
            List<Integer> neighbors = new ArrayList<>();
            // check up
            if(row - 1 >= 0 && disjoint.valid((row - 1) * n + col)) {
                neighbors.add((row - 1) * n + col);
            }
            // check down
            if(row + 1 < m && disjoint.valid((row + 1 ) * n + col)) {
                neighbors.add((row + 1) * n + col);
            }
            // check left 
            if(col - 1 >= 0 && disjoint.valid(row * n + col - 1)) {
                neighbors.add(row * n + col - 1);
            }
            // check right
            if(col + 1 < n && disjoint.valid(row * n + col + 1)) {
                neighbors.add(row * n + col + 1);
            }
            // create unions
            for(int i : neighbors) {
                disjoint.union(i, curIndex);
            }
            
            // add the current count of islands to the list
            result.add(disjoint.getCount());
            
        }
        
        return result;
        
    }
}