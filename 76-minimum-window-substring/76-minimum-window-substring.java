class Solution {
    public String minWindow(String s, String t) {
        // sliding window 

        int left = 0, right = 0, len = s.length(), count = t.length();
        HashMap<Character, Integer> tMap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> windowMap = new HashMap<Character, Integer>();
        
        int min_left = 0;
        int min_right = 0;
        int min_length = Integer.MAX_VALUE;
        boolean change = false;
        
        // handle bad input 
        if(count > len || len == 0 || count == 0) return "";
        

        // init our map for T
        for(char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        
        // number of unique character that need to be preset in the window 
        int required = tMap.size();
        int currentCount = 0;
        
        // window 
        while(right < len) {
            // add to the window 
            char temp = s.charAt(right);
            windowMap.put(temp, windowMap.getOrDefault(temp, 0) + 1);
            
            // if the frequency in the window is the frequency we need, increment currentCount by 1.
            // CurrentCount is only incremented when we have enough instances of a distinct value from T, in S. 
            if(tMap.containsKey(temp) && windowMap.get(temp).intValue() == tMap.get(temp).intValue()) {
                currentCount++;
            }
            
            // while the subarray is valid and left is <= right, contract the window until it becomes not valid. 
            while(left <= right && currentCount == required) {
                change = true;
                char leftChar = s.charAt(left);
                if(right - left + 1 < min_length) {
                    min_length = right - left + 1;
                    min_left = left;
                    min_right = right;
                }
                
                // if when we decrement, the # of occurences in s goes below # of occurences in t, its no longer included in count. 
                // when currentCount != required, we dont have all instances required of each distinct character.
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                if(tMap.containsKey(leftChar) && windowMap.get(leftChar).intValue() < tMap.get(leftChar).intValue()) {
                    currentCount--;
                }
                left++; 
            }
            right++;
        }
        
        if(change) { 
            return s.substring(min_left, min_right + 1);
        }
        else {
            return "";
        }
    
    }
    
   
}