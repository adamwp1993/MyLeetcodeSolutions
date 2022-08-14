class Solution {
    public int numIslands(char[][] grid) {
        // each element represents a node. 
        // search 2d array until we find a 1. then fire off dfs it its unvisited. 
        // if the array element is 0, then we just ignore it. 
        // can be solved with unionfind and dfs.
        
        int row = grid.length;
        int col = grid[0].length;
        
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        boolean[][] visited = new boolean[row][col];
        
        int num_islands = 0;
        // any time we hit an unvisited peice of land, run dfs 
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == '1' && !visited[i][j] ) {
                    num_islands++;
                    dfs(grid, i, j, visited);
                }
            }
        }
        
        return num_islands;
        
    }
    
    public void dfs(char[][] grid, int row, int col, boolean[][] visited) {
        int maxRow = grid.length;
        int maxCol = grid[0].length;
        
        // check for invalid indexs, if we have visited the node, or its a 0 (water)
        if( row < 0 || col < 0 || row >= maxRow || col >= maxCol || grid[row][col] == '0' || visited[row][col] ) return;
        
        // mark as visited
        visited[row][col] = true;
        // recursively call dfs up, down, right, and left 
        dfs(grid, row - 1, col, visited);
        dfs(grid, row + 1, col, visited);
        dfs(grid, row, col - 1, visited);
        dfs(grid, row, col + 1, visited);
        
    }
}