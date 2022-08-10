class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 0) return false;
        int len = nums.length;
        
        int furthestIndex = 0;
        // Greedy algorithm 
        // store the furthest index we can reach for each index in the array 
        // if any index is greater than nums.length - 1, we have reached end of array and its valid
        for(int i = 0; i <= furthestIndex && i < len; ++i) {
            
            furthestIndex = Math.max(furthestIndex, i + nums[i]);
            
            if(furthestIndex > len - 1) return true;
        }
        
        return furthestIndex >= len - 1;
        
        
    }

}