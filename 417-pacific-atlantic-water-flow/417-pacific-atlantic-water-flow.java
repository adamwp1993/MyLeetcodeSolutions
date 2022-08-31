class Solution {
    private static final int[][] directions = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        
        if(heights.length == 0 || heights[0].length == 0) return result;
        // Start with each ocean. perform a BFS from each ocean, keeping track of the cells that can be visited from each ocean. 
        // Once we have determined them, find the intersection and return it. 
        
        // n = row, m = column
        int n = heights.length;
        int m = heights[0].length;
        
        // pacific ocean runs along left and top edges. (0, x) and (x, 0)
        Queue<int[]> pacificQueue = new LinkedList<>();
        boolean[][] pacificReached = new boolean[n][m];
        
        
        
        // atlantic ocean runs along bottom and right edges(n - 1, x) and (x, m - 1)
        Queue<int[]> atlanticQueue = new LinkedList<>();
        boolean[][] atlanticReached = new boolean[n][m];
        // add all ocean edges to respective queue
        // add vertical linees. pacific is 0, atlantic is m - 1
        for(int i = 0; i < n; i++) {
            pacificQueue.add(new int[]{i, 0});
            atlanticQueue.add(new int[]{i, m - 1});
        }
        // add horizontal lines. pacific is (0, j) and atlantic is (n - 1, j)
        for(int j = 0; j < m; j++) {
            pacificQueue.add(new int[] {0, j});
            atlanticQueue.add(new int[] {n - 1, j});
        }
        
        // run a BFS to find all reachable cells from each ocean 
        atlanticReached = bfs(atlanticQueue, heights, n, m);
        pacificReached = bfs(pacificQueue, heights, n, m);
        
        // now find the intersection 
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(atlanticReached[i][j] && pacificReached[i][j]) {
                    result.add(List.of(i, j));
                }
            }
        }
        return result;
        
    }
    
    public boolean[][] bfs(Queue<int[]> q, int[][] matrix, int n, int m) {
        // start along the ocean edge and move inwards.
        // inland cells are considered reachable if newCell >= to the current one. 
        boolean[][] reached = new boolean[n][m];
        while(!q.isEmpty()) {
            int[] curCell = q.poll();
            // mark reached 
            int row = curCell[0];
            int col = curCell[1];
            reached[row][col] = true;
            // next evaluate neighbors if
            for(int[] nextDir : directions) {
                // get the indices 
                int newRow = row + nextDir[0];
                int newCol = col + nextDir[1];
                // check that indices are valid, not previously visited, and GREATER or EQUAL THAN the current height
                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && !reached[newRow][newCol] && matrix[newRow][newCol] >= matrix[row][col]) {
                    q.add(new int[] {newRow, newCol});
                }
            }  
        }
        return reached;
        
    }
}