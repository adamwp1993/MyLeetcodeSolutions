class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // key = element values 
        // value = number of instances 
        HashMap<Integer, Integer> vals = new HashMap<Integer, Integer>();
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int p1 = 0;
        
        // add values from one array to HashMap
        for(int i = 0; i < nums1.length; i++) {
            if(vals.containsKey(nums1[i])) {
                // if the value is included increment the count. 
                vals.put(nums1[i], vals.get(nums1[i]) + 1);
            }
            else {
                vals.put(nums1[i], 1);
            }
        }
        
        // iterate through other array, check for intersection, decrement HashMap. 
        for(int j = 0; j < nums2.length; j++) {
            
            // if exists and instance count is greater than 1, decrement 
            if(vals.containsKey(nums2[j]) && vals.get(nums2[j]) > 1) {
                vals.put(nums2[j], vals.get(nums2[j]) - 1);
                ans.add(nums2[j]);
                
            }
            // else if it exists with one instance, remove from the hashmap 
            else if(vals.containsKey(nums2[j])) {
                vals.remove(nums2[j]);
                ans.add(nums2[j]);
                
            }
        }
        // translate Integer ArrayList to int array 
        int[] res = ans.stream().mapToInt(i -> i).toArray();
        return res;
        
    }
}