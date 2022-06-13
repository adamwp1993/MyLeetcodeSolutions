class Solution {
    public int longestOnes(int[] nums, int k) {
        // sliding window O(N)
        int left = 0, longest = 0;
        int[] counters = new int[2];
        
        // expand window until we encounter 
        for(int right = 0; right < nums.length; right++) {
            int temp = nums[right];
            counters[temp]++;
            
            // if not valid contract window until we drop enough 0's
            while(counters[0] > k && left <= right) {
                int remove = nums[left];
                counters[remove]--;
                left++;
            }
            longest = Math.max(longest, right - left + 1);
        }
        return longest;
    }
}