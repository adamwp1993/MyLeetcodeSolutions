class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<String>(n);
        
        for(int i = 0; i < n; i++) {
            
            if((i + 1) % 3 == 0 && (i + 1) % 5 == 0 ) {
                answer.add("FizzBuzz");
                continue;
            }
            else if((i + 1) % 3 == 0) {
                answer.add("Fizz");
                continue;
            }
            else if((i + 1) % 5 == 0) {
                answer.add("Buzz");
                continue;
            }
            else {
                answer.add(Integer.toString(i + 1));
            }
            
        }
        return answer;
    }
}