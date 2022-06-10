class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // sliding window 
        // init range and vars 
        int longest = 0;
        int current = 0;
        // holds the distinct character and number of occurences. 
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        int start = 0;
        int end = 0;
        char[] vals = s.toCharArray();
        int n = vals.length;
        
        // expand window until the substring is not valid.
        while(end < n) {
            // add to map or update # of occurences if we've already encountered it. 
            if(map.containsKey(vals[end])) {
                map.put(vals[end], map.get(vals[end]) + 1);
            }
            else {
                map.put(vals[end], 1);
            }
            // update counters. 
            current++;
            if(map.size() <= k) {
                longest = Math.max(longest, current);
            }
            // contract window if not valid, until the window is valid again. 
            while(map.size() > k && start < end) {
                if(map.get(vals[start]) > 1) {
                    map.put(vals[start], map.get(vals[start]) - 1);
                }
                else {
                    map.remove(vals[start]);
                }
                // update start position and decrement current string length.
                start++;
                current--;
                
            }
            // increment end index. 
            end++;
        }
        return longest;
    }
}