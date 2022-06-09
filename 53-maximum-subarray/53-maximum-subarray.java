class Solution {
    public int maxSubArray(int[] nums) {
        // Kadenes 
        
        int maxCurr = nums[0];
        int maxGlobal = nums[0];
        // start at 1 since we updated 0 above 
        for(int i = 1; i < nums.length; i++) {
            // determine if previous subarray + nums[i] is > than just nums[i]
            // if nums[i] is greater we restart the contiguous subarray. 
            maxCurr = Math.max(nums[i], nums[i] + maxCurr);
            // if this is larger than previous global, we update the prevous global
            if(maxCurr > maxGlobal) {
                maxGlobal = maxCurr; 
            }
        }
        return maxGlobal;
    }
    
    
}