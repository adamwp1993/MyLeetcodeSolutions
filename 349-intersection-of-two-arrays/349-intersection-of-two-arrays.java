class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<Integer>();
        ArrayList<Integer> vals = new ArrayList<Integer>();
        
        // add to hashmap 
        for(int i : nums1) {
            set.add(i);
        }
        
        // find collisons 
        for(int j : nums2) {
            if(set.contains(j)) {
                vals.add(j);
                set.remove(j);
            }
        }
        // conver Integer arrayList to int array 
        int[] result = new int[vals.size()];
        for(int n = 0; n < vals.size(); n++) {
            result[n] = vals.get(n);
        }
        return result;
    }
}