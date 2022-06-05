class Solution {
    public int firstUniqChar(String s) {
        // worst case runtime = O(2N) aka. O(N)
        // create structures 
        Queue<Character> q = new LinkedList<Character>();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        char[] chars = s.toCharArray();
        
        // loop through, add to queue and update occurences in map 
        for(int i = 0; i < chars.length; i++) {
            q.add(chars[i]);
            if(map.containsKey(chars[i])) {
                map.put(chars[i], (map.get(chars[i]) + 1));
            }
            else{
                map.put(chars[i], 1);
            }
            
        }
        // now we go through queue, poll values, and check number of occurences for that value, while keeping track of index. 
        int index = 0;
        while(!q.isEmpty()) {
            char c = q.poll();
            if(map.get(c) == 1) {
                return index;
            }
            else {
                index++;
            }
        }
        
        return -1;
    }
}