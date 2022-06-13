class Solution {
    public int characterReplacement(String s, int k) {
        // init range and data structures 
        // HashMap key = character and Value = # of occurences in subarray 
        int left = 0, longest = 0, mostFreq = 0;
        
        
        int[] counters = new int[26];
        
        // expand window
        for(int right = 0; right < s.length(); right++) {
            // update counter 
            counters[s.charAt(right) - 'A']++;
            // Determine most frequent character 
            mostFreq = Math.max(mostFreq, counters[s.charAt(right) - 'A']);
            // find out how many we have to change 
            int change = (right - left + 1) - mostFreq;
            if(change > k) {
                counters[s.charAt(left) - 'A']--;
                left++;
            }
            longest = Math.max(longest, right - left + 1);
        }
        return longest;
        
    }
}