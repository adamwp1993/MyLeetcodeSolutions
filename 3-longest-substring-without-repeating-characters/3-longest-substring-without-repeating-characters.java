class Solution {
    public int lengthOfLongestSubstring(String s) {
        // sliding window O(N)
        // init range and vars
        int left = 0, right = 0, longest = 0;
        // Hash table stores character as key and last index character was encountered as value
        char[] vals = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        // expand window until subarray not valid 
        for(; right < vals.length; right++) {
            
            // contract window until subarray is valid 
            // could have just used an if statement here 
           if(map.containsKey(vals[right])) {
                // remove to right most instance of that char so there is no dupe  
                left = Math.max(left, map.get(vals[right]) + 1);
            }
            map.put(vals[right], right);
            longest = Math.max(longest, right - left + 1);
              
            
        }
        return longest;
    }
}