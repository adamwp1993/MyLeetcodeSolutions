class Solution {
    public int characterReplacement(String s, int k) {
        // init range and data structures 
        // HashMap key = character and Value = # of occurences in subarray 
        int left = 0, right = 0, longest = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        char[] vals = s.toCharArray();
        
        // expand window, updating counters along the way, until subarray is not valid. 
        for(; right < vals.length; right++) {
            // add to hashMap 
            if(map.containsKey(vals[right])) {
                map.put(vals[right], map.get(vals[right]) + 1);
            }
            else {
                map.put(vals[right], 1);
            }
            // determine String w/ most occurences and how many occurences it had
            int highest = 0;
            Character mostOccur;
            for(Character key : map.keySet()) {
                if(highest < map.get(key)) {
                    mostOccur = key;
                    highest = map.get(key);
                }
            }
            // if valid subarray update longest subarray encountered 
            if((right - left + 1) - highest <= k) {
                longest = Math.max(longest, right - left + 1);
            }
            // while subArray is not valid, contract window 
            while((right - left + 1) - highest > k && left <= right) {
                // decrement val, move left pointer 
                map.put(vals[left], map.get(vals[left]) - 1);
                left++;
                // re-calculate most occured 
                highest = 0;
                for(Character key: map.keySet()) {
                    if(highest < map.get(key)) {
                        mostOccur = key;
                        highest = map.get(key);
                    }
                }
            }
        }
        return longest;
        
    }
}