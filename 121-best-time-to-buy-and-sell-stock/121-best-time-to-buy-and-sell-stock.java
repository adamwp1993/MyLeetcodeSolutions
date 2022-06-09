class Solution {
    public int maxProfit(int[] prices) {
        
        // Kadenes
        // O(N)
        int currMax = 0;
        int globalMax = 0;
        
        for(int i = 1; i < prices.length; i++) {
            // determine if previous subarrays difference plus this values difference is greater or less 0.
            // if less than we reset to 0. 
            // if the difference is greater than anything we've seen previously, update global. 
            currMax = Math.max(0, currMax += prices[i] - prices[i-1]);
            if(currMax > globalMax) {
                globalMax = currMax;
            }                                                                                                                                                                                                                                       
        }
        return globalMax;
    
    }
}