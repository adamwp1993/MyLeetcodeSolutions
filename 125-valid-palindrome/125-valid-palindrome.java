class Solution {
    public boolean isPalindrome(String s) {
        // format string 
        
        
        char[] chars = s.toLowerCase().toCharArray();
        
        
        if(chars.length <= 1) return true;
        
        int left = 0;
        int right = chars.length - 1;
        
        while (left < right) {
            if(!Character.isLetterOrDigit(chars[left])) {
                left++;
                continue;
                
            }
            if(!Character.isLetterOrDigit(chars[right])) {
                right--;
                continue;
            }
            
            if(Character.isLetterOrDigit(chars[right]) && Character.isLetterOrDigit(chars[left]) && chars[left] != chars[right]) {
                return false;
            }
            else{
                left++;
                right--;
            }
            
        }
        return true;
    }
}