class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Brute force 
        int longest = 0;
        char[] chars = s.toCharArray();
        
        if(chars.length == 1) return 1;
        
        for(int i = 0; i < chars.length; i++) {
            HashSet<Character> vals = new HashSet<Character>();
            int length = 0;
            for(int j = i; j < chars.length; j++) {
                if(vals.contains(chars[j])) {
                    // check against res. if its longer, update res 
                    if(length > longest) {
                        longest = length;
                    }
                    break;
                }
                length++;
                vals.add(chars[j]);
            
            }
            if(length > longest) {
                        longest = length;
            }
            
        }
        return longest;
    
    }
}