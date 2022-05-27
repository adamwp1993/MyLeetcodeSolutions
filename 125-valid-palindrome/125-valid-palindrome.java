class Solution {
    public boolean isPalindrome(String s) {
        // format string 
        
        s = s.replaceAll("[^A-Za-z0-9]","").toLowerCase();
        char[] chars = s.toCharArray();
        
        if(chars.length <= 1) return true;
        
        for(int i = 0; i < (chars.length / 2) + 1; i++) {
            if(chars[i] != chars[chars.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}