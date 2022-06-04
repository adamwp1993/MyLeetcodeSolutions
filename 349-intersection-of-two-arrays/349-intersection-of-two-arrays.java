class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        ArrayList<Integer> vals = new ArrayList<Integer>();
        
        // add to hashmap 
        for(int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], true);
        }
        
        // find collisons 
        for(int j = 0; j < nums2.length; j++) {
            if(map.get(nums2[j]) == null) {
                continue;
            }
            if(map.get(nums2[j])) {
                vals.add(nums2[j]);
                map.remove(nums2[j]);
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