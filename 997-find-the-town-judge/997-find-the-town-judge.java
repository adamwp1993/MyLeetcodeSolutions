class Solution {
    public int findJudge(int n, int[][] trust) {
        // increases if this person trusts someone.
        int[] trusts = new int[n];
        // increases if this person is trusted by someone.
        int[] trustedBy = new int[n];
        // The judge is trusted by everone (n -1), but trusts no one 
        
        // populate the arrays 
        for(int i = 0; i < trust.length; i++) {
            // we are subtracting 1 because the people are 1-indexed.
            trusts[trust[i][0] - 1]++;
            trustedBy[trust[i][1] - 1]++;
        }
        
        int judge = -1;
        // find the judge 
        for(int i = 0; i < n; i++) {
            if(trusts[i] == 0 && trustedBy[i] == n - 1) {
                // add 1 because we are 1-indexed. 
                judge = i + 1;
                return judge;
            }
        }
        return judge;
        
        
    }
    
    
}