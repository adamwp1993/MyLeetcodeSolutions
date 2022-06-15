class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // sliding window O(N)
        int[] counters1 = new int[26];
        int[] counters2 = new int[26];
        int left = 0;
        // init counters for s1 
        for(int i = 0; i < s1.length(); i++) {
            ++counters1[s1.charAt(i) - 'a'];
        }
        for(int right = 0; right < s2.length(); right++) {
            ++counters2[s2.charAt(right) - 'a'];
            // eval if valid subarray 
            boolean valid = true;
            for(int j = 0; j < s1.length(); j++) {
                if(counters1[s1.charAt(j) - 'a'] != counters2[s1.charAt(j) - 'a']) {
                    valid = false;
                    break;
                }
            }
            if(valid) return true;
            // slide window to the right if subarray length = s1.length()
            if(right - left + 1 == s1.length()) {
                --counters2[s2.charAt(left) - 'a'];
                left++;
            }
        }
        return false;
        
        
    }
}