class Solution {
    public boolean isAnagram(String s, String t) {
        
        // edge and corner cases 
        if(s == t) return true;
        if(s.length() != t.length()) return false;
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        
        HashMap<Character, Integer> sMap = new HashMap<>();
        for(char c : sChars) {
            // increment the count if it exists, else add it
            if(sMap.containsKey(c)) {
                sMap.put(c, sMap.get(c) + 1);
            }
            else {
                sMap.put(c, 1);
            }
        }
        
        
        // loop through other string array and count down the counters. at the end they should all be           equal to 0.immeidately return false if we hit a value that doesnt exist. 
        for(char k : tChars) {
            if(!sMap.containsKey(k)) {
                return false;
            }
            else {
                sMap.put(k, sMap.get(k) - 1);
            }
        }
        
        for(char e: sMap.keySet()) {
            if(sMap.get(e) != 0) {
                return false;
            }
        }
        return true;
    }
}