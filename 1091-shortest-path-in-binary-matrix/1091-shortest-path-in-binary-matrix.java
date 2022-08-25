class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        if(grid[0][0] == 1) return -1;
        
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new ArrayDeque<>();;
        q.add(new int[]{0, 0, 1});
        visited[0][0] = true;
        
        // start BFS 
        while(!q.isEmpty()) {
            int[] curNode = q.remove();
            int row = curNode[0];
            int col = curNode[1];
            int distance = curNode[2];
            // if the current node is the bottom right corner, return the distance 
            if(row == n - 1 && col == m - 1) return distance;
            // mark visited 
            visited[row][col] = true;
            
            // get all neighbors 
            List<int[]> neighbors = getNeighbors(row, col, grid);
            // add valid neighbors to the queue 
            for(int[] neighbor : neighbors) {
                int nRow = neighbor[0];
                int nCol = neighbor[1];
                if(visited[nRow][nCol]) {
                    continue;
                }
                visited[nRow][nCol] = true;
                q.add(new int[] {nRow, nCol, distance + 1});
            }
            // mark visited 
            visited[row][col] = true;
            
            
        }
        
        return -1;
    }
    
    public List<int[]> getNeighbors(int row, int col, int[][] grid ) {
        // returns a 2d list of all valid, unvisited neighbor nodes 
        // 8 directions 
        int[][] directions = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1},{1, -1}, {1, 0}, {1, 1}};
        List<int[]> neighbors = new ArrayList<>();
        
        for(int i = 0; i < directions.length; i++) {
            int newRow = row + directions[i][0];
            int newCol = col + directions[i][1];
            // validate the cell position, make sure indices are within bounds, its a cell with 0 and hasnt been visited 
            if(newRow < 0 || newCol < 0 || newRow >= grid.length || newCol >= grid[0].length || grid[newRow][newCol] != 0) {
                continue;
            }
            neighbors.add(new int[]{newRow, newCol});
        }
        
        return neighbors;
        
        
        
    }
}