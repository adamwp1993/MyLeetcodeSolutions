class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        // sliding window 
        
        int left = 0;
        List<Integer> result = new ArrayList<Integer>();
        // track vals w/ arrays 
        int[] scounter = new int[26];
        int[] pcounter = new int[26];
        
        if(s.length() < p.length()) return result;
            
        // count string p 
        for(int i = 0; i < p.length(); i++) {
            ++pcounter[p.charAt(i) - 'a'];
        }
        
        // window 
        for(int right = 0; right < s.length(); right++) {
            ++scounter[s.charAt(right) - 'a'];
            // check if window is valid 
            
            if(Arrays.equals(scounter, pcounter)) result.add(left);
            // slide window right 
            if(right - left + 1 == p.length()) {
                --scounter[s.charAt(left) - 'a'];
                left++;
            }
        }
        return result;
        
    }
}