class Solution {
    public int orangesRotting(int[][] grid) {
        boolean[][] rotten = new boolean[grid.length][grid[0].length];
        Queue<int[]> q = new LinkedList<>();
        // find all oranges that are rotten at start, count number of oranges and rotten oranges to set up the BFS
        int orangeCount = 0;
        int rottenCount = 0; // makes sure all oranges in the matrix are rotten
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1 || grid[i][j] == 2) {
                    orangeCount++;
                }
                if(grid[i][j] == 2) {
                    
                    q.add(new int[]{i, j});
                }
            }
        }
        // Handle corners case i.e if all oranges are already rotten or if no rotten oranges exist.
        // what if orangecount is 0?
        if(orangeCount == rottenCount) return 0;
        // Run the BFS 
        int minute = -1; // first iteration doesnt count
        
        while(!q.isEmpty()) {
            int size= q.size();
            for(int i = 0; i < size; i++) {
                int[] cell = q.poll();
                
                int row = cell[0];
                int col = cell[1];
                // if its already rotten continue 
                if(rotten[row][col]) continue;
                // mark current orange as rotten and increase rotten count
                rotten[row][col] = true;
                rottenCount++;
                // add neighbors to the queue if its an un-rotten orange 
                if(row + 1 < grid.length && grid[row + 1][col] == 1 && !rotten[row + 1][col]) {
                    q.add(new int[] {row + 1, col});
                }
                if(row - 1 >= 0 && grid[row - 1][col] == 1 && !rotten[row - 1][col]) {
                    q.add(new int[] {row - 1, col});
                }
                if(col + 1 < grid[0].length && grid[row][col + 1] == 1 && !rotten[row][col + 1]) {
                    q.add(new int[] {row, col + 1});
                }
                if(col - 1 >= 0 && grid[row][col - 1] == 1 && !rotten[row][col - 1]) {
                    q.add(new int[] {row, col - 1});
                }
            }
            // each iteration of the BFS is one minute
            minute++;
            if(rottenCount == orangeCount) return minute;
            
        }
        // if all oranges did not rot, that means at least 1 is unreachable. so return -1
        return -1;
        
    }
}