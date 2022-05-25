class Solution {
    public int maxProfit(int[] prices) {
        
        int bestProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        
        for(int i = 0; i < prices.length; i++) {
            
            if(prices[i] < minPrice) {
                minPrice = prices[i];
            }
            
            else if(prices[i] - minPrice > bestProfit) {
                bestProfit = prices[i] - minPrice;
            }
            
        }
        return bestProfit;
        
    }
    
    
}