class Solution {
    public int totalFruit(int[] fruits) {
        // sliding window - we are finding largest subarray w/ 2 distinct values essentially
        // O(N) complexity 
        
        // init range and vars 
        int left = 0,   longest = 0;
        int n = fruits.length;
        // HashTable - key is the fruit type, value is the last index we encountered it
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        // expand window until subarray is not valid 
        for(int right = 0; right < n; right++) {
            map.put(fruits[right], right);
            
            // contract window until subarray is valid
            while(map.size() > 2 && left <= right) {
                // get minimum index and reset left pointer to right after it.
                int minIndex = Collections.min(map.values());
                map.remove(fruits[minIndex]);
                left = minIndex + 1;
                
            }
            // update the longest length if current length of array is longer. 
            longest = Math.max(right - left + 1, longest);
        }
        return longest;
    }
}