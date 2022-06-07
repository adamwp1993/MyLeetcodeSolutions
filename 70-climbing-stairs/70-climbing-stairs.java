class Solution {
    public int climbStairs(int n) {
        // dynamic programming 
        int[] vals = new int[n];
        if(n == 1) return 1;

        vals[0] = 1;
        vals[1] = 2;

        for(int i = 2; i < n; i++) {
            vals[i] = vals[i - 1] + vals[i - 2];
        }
        return vals[n - 1];
    }
}