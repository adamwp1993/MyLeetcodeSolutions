class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> vals = new HashSet<>();
        
        for(int i = 0; i < nums.length; i++) {
            if(vals.contains(nums[i])) return true;
            vals.add(nums[i]);
        }
        return false;
    }
}