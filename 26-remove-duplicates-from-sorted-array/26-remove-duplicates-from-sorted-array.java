class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 0;
        int n = nums.length;
        HashSet<Integer> seen = new HashSet<Integer>();
        
        for(int i = 0; i < n; i++) {
            if(seen.contains(nums[i])) {
                k++;
            }
            else {
                seen.add(nums[i]);
            }
            nums[i - k] = nums[i];
        }
        return n - k;
        
    }
}