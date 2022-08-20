class Solution {
    public void solve(char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        // traverse the matrix and run dfs
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                
                List<List<Integer>> overwriteCoords = new ArrayList<>();
                
                // if the component is surrounded (DFS returns false), overwrite all cells in the component 
                if(!dfs(board, i, j, visited, overwriteCoords)) {
                    overwrite(board, overwriteCoords);
                }
                
            }
        }
    }
    
    
    public boolean dfs(char[][] board, int x, int y, boolean[][] visited, List<List<Integer>> overwrite) {
        if(visited[x][y] || board[x][y] == 'X') return false;
        
        // mark visited and add this to the list 
        List<Integer> coords = new ArrayList<>();
        coords.add(x);
        coords.add(y);
        overwrite.add(coords);
        visited[x][y] = true;
        // If we are touching the edge of the matrix then the component is not surrounded. 
        int maxX = board.length - 1;
        int maxY = board[0].length - 1;
        boolean edge = false;
        if(x == maxX || x == 0 || y == maxY || y == 0) {
            edge = true;
        }
        // traverse neighbors 
        if(x + 1 < board.length && board[x + 1][y] == 'O' && dfs(board, x + 1, y, visited, overwrite)) {
            edge = true;
        }
        if(x - 1 >= 0 && board[x - 1][y] == 'O' && dfs(board, x - 1, y, visited, overwrite)) {
            edge = true;
        }
        if(y + 1 < board[0].length && board[x][y + 1] == 'O' && dfs(board, x, y + 1, visited, overwrite)) {
            edge = true;
        }
        if(y - 1 >= 0 && board[x][y - 1] == 'O' && dfs(board, x, y - 1, visited, overwrite)) {
            edge = true;
        }
        
        // if any cell in the whole component touches the edge of the matrix, its not surrounded. 
        return edge;
    }
    
    public void overwrite(char[][] board, List<List<Integer>> overwrite) {
        for(List<Integer> coord : overwrite) {
            board[coord.get(0)][coord.get(1)] = 'X';
        }
    }
}

