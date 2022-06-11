class Solution {
    public int totalFruit(int[] fruits) {
        // sliding window - we are finding largest subarray w/ 2 distinct values essentially
        // O(N) complexity 
        
        // init range and vars 
        int left = 0,  current = 0, longest = 0;
        int n = fruits.length;
        // HashTable - key is the fruit type, value is the last index we encountered it
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        // expand window until subarray is not valid 
        for(int right = 0; right < n; right++) {
            if(!map.containsKey(fruits[right])) {
                map.put(fruits[right], 1);
            }
            else {
                map.put(fruits[right], map.get(fruits[right]) + 1);
            }
            current++;
            
            if(map.size() <= 2) {
                longest = Math.max(current, longest);
            }
            
            // contract window until subarray is valid
            while(map.size() > 2 && left < right) {
                if(map.get(fruits[left]) > 1) {
                    map.put(fruits[left], map.get(fruits[left]) - 1);
                }
                else{
                    map.remove(fruits[left]);
                }
                left++;
                current--;
            }
        }
        return longest;
    }
}