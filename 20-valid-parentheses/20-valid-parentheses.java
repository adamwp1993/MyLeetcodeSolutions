class Solution {
    
    private HashMap<Character, Character> map;
    
    public Solution() {
        this.map = new HashMap<Character, Character>();
        this.map.put(')', '(');
        this.map.put(']', '[');
        this.map.put('}', '{');
    }
    public boolean isValid(String s) {
        
        
        
        Stack<Character> stack = new Stack<Character>();
        
        for(int i = 0; i < s.length(); i++) {
            
            char temp = s.charAt(i);
            
            // if its an closing bracket
            if(this.map.containsKey(temp)) {
                // check the stack for most recent open bracket 
                char top = stack.empty() ? '#' : stack.pop();
                // if the most recent closing bracket doesnt match, invalid expression
                if(top != this.map.get(temp)) { 
                    return false; 
                }
            }
            
        
            else {
                // push open bracket to stack 
                stack.push(temp);
            }

            // if stack has elements then expression is invalid 
            
        }
        return stack.isEmpty();
    }
}
