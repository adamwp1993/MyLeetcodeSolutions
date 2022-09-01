class Solution {
    private static final int[][] directions = new int[][] {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        // n x n grid
        int n = grid.length;
        // prepare data structures for BFS
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        // add top left corner to the queue if its a 0. if not, we cant reach it, so return -1
        if(grid[0][0] == 0) {
            q.offer(new int[] {0, 0, 1});
        }
        else {
            return -1;
        }
        
        // run dfs 
        while(!q.isEmpty()) {
            for(int i = q.size(); i > 0; i--) {
                int[] cell = q.poll();
                int row = cell[0];
                int col = cell[1];
                int distance = cell[2];
                // condition met - bottom right cell reached, return distance 
                if(row == n - 1 && col == n - 1) return distance;

                // mark visited if not already 
                visited[row][col] = true;
                // evaluate neighbors 
                for(int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    // validate the indices, check that its a traversable cell (a 0), and that its not prevously been visited. 
                    if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && !visited[newRow][newCol] && grid[newRow][newCol] == 0 ) {

                        q.offer(new int[] {newRow, newCol, distance + 1});
                        // this is because the same cell is getting added to array multiple times causing TLE. so a cell may be added multiple times before
                        // we get a chance to evaluate it and set visited to true, which wastes time and space in our queue.
                        visited[newRow][newCol] = true;
                        
                    }
                }
            }
                   
        }
        // if we make it here, that means we did not find a path. return -1
        return -1;
        
        
        
    }
}