class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        // DFS solution, O(N * M) or O(N) where N = number of cells in the matrix
        // trigger DFS when we hit a "land" cell that has not been visited yet. 
        int nr = grid.length;
        int nc = grid[0].length;
        boolean[][] visited = new boolean[nr][nc];
        int maxArea = 0;
        int count = 0;
        // traverse matrix, dfs function is called at each cell, but a dfs is only actually triggered on "land" cell that is unvisited.
        for(int i = 0; i < nr; i++) {
            for(int j = 0; j < nc; j++) {
                int current = 0;
                current = dfs( i, j, grid, visited);
                maxArea = Math.max(maxArea, current);
            }
        }
        
        return maxArea;
    }
    
    public int dfs( int row, int col, int[][] grid, boolean[][] visited) {
        int maxRows = grid.length;
        int maxCols = grid[0].length;
        int count = 0;
        // if index is invalid, we've already visited this cell in the matrix, or if its "Water" (a 0), dont run dfs, just return.
        if(row < 0 || col < 0 || row >= maxRows || col >= maxCols || grid[row][col] == 0 || visited[row][col]) return 0;
        
        // mark visited and increase count 
        visited[row][col] = true;
        count++;
        
        // visit neighbor cells 
        count += dfs( row + 1, col, grid, visited);
        count += dfs( row - 1, col, grid, visited);
        count += dfs( row, col + 1, grid, visited);
        count += dfs( row, col - 1, grid, visited);
        
        return count;
    }
}