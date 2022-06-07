class Solution {
    public int fib(int n) {
        // DP 
        if(n <= 1) return n;


        int[] vals = new int[n + 1];
        vals[1] = 1;
        for(int i = 2; i <= n; i++) {
            vals[i] = vals[i - 1] + vals[i - 2];
        }
        return vals[n];
    }

}