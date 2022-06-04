class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> vals = new HashSet<Integer>();
        
        for(int i: nums) {
            if(vals.contains(i)) {
                return i;
            }
            else {
                vals.add(i);
            }
        }
        return -1;
    }
}