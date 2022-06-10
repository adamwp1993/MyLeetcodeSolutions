class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // Sliding window Pattern 
        int smallestLength = Integer.MAX_VALUE;
        
        // create range 
        int left = 0;
        int right = 0;
        int sum = 0;
        // expand subarray until condition is met 
        while(right < nums.length) {
            sum += nums[right];
            right++;
            // once condition is met, contract until it is not
            // make sure we dont accidentally pass 
            while(sum >= target && left < right) {
                sum -= nums[left];
                left++;
                smallestLength = Math.min(smallestLength, right - left + 1);
            }
        }
        if(smallestLength == Integer.MAX_VALUE) return 0;
        else return smallestLength;
    }
}