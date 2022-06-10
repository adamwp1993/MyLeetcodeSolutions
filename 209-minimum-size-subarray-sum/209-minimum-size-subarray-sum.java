class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // Sliding window Pattern 
        int smallestLength = Integer.MAX_VALUE;
        int len = nums.length;
        // create range 
        int left = 0;
        int right = 0;
        int sum = 0;
        // expand subarray until condition is met 
        while(right < len) {
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
        return smallestLength == Integer.MAX_VALUE ? 0 : smallestLength;
    }
}