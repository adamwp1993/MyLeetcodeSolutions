class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int k = 0; 
        HashSet<Integer> seen = new HashSet<Integer>();
        
        // replace dupes with a value we know to be outside the range 
        for(int i = 0; i < n; i++) {
            if(seen.contains(nums[i])) {
                nums[i] = 1000;
            }
            else {
                seen.add(nums[i]);
                k++;
            }
        }
        // then we just sort!
        Arrays.sort(nums);
        return k;
        
    }
}