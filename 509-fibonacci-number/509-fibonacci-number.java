class Solution {
    public int fib(int n) {
        // recursive solution bottom up
        if(n <= 1) return n;
        
        int[] vals = new int[2];
        vals[1] = 1;
        
        calc(vals, 2, n);
        return vals[1];

    }
    
    public int[] calc(int[] vals, int step, int n) {
        if(step > n) {
            return vals;
        }
        int current = vals[0] + vals[1];
        vals[0] = vals[1];
        vals[1] = current;
        
        vals = calc(vals, step + 1, n);
        return vals;
    }

}