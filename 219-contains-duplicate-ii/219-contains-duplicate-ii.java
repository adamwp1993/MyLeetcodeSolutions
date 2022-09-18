class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // Hash Table holds the most recent index of an element 
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            // if we find a duplicate, evaluate if it meets the criteria
            if(map.containsKey(nums[i])) {
                // determine if absolute value of i - j <= k
                int j = map.get(nums[i]);
                if(Math.abs(i - j) <= k) {
                    return true;
                }
            }
            // else we update the most recent index of this value. 
            map.put(nums[i], i);
        }
        // return false if no valid condition existed 
        return false;
    }
}