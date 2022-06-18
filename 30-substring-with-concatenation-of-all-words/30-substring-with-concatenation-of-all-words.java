class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        // Sliding window 
        int numWords = words.length, stringSize = words[0].length(), left = 0, right = (numWords * stringSize) - 1;
        // handle incorrect input 
        if(s.length() < numWords * stringSize) {
            return new ArrayList<Integer>();
        }
        // HashMaps track word counts 
        HashMap<String, Integer> wordsMap = new HashMap<String, Integer>();
        HashMap<String, Integer> windowMap = new HashMap<String, Integer>();
        // init wordsMap
        for(String t: words) {
            wordsMap.put(t, wordsMap.getOrDefault(t, 0) + 1);
        }
        // distinct = number of distinct words we need
        // current gets incremented, when we have encountered the needed number of occurences of that word, in our subArray
        int distinct = wordsMap.size(), current = 0;
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        // Window stays the same size since we know exaclty how big it needs to be. 
        while(right < s.length()) {
            // check if words at the correct start indexes are valid. since each word is the same we know exactly where each word is supposed to start. 
            
            for(int i = 0; i < numWords; i++) {
                int startIndex = left + (stringSize * i);
                String temp = s.substring(startIndex, startIndex + stringSize);
                // update window map and counter if it exists.
                if(wordsMap.containsKey(temp)) {
                    windowMap.put(temp, windowMap.getOrDefault(temp, 0) + 1);
                    if(wordsMap.get(temp).intValue() == windowMap.get(temp).intValue()) {
                        current++;
                    }
                }
                // if we hit a single subString that is not in our map, entire window is invalid, reset and break 
                else {
                    current = 0;
                    break;
                }
            }
            // condition met
            if(distinct == current) {
                result.add(left);
            }
            // reset window and increment 
            current = 0;
            windowMap.replaceAll((k,v) -> v=0);
            left++;
            right++;
            
        }
        return result;
       
    }
}