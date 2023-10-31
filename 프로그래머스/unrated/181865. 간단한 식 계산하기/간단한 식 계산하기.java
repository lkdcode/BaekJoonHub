class Solution {
    public int solution(String binomial) {
        int answer = 0;
        
        String[] split = binomial.split(" ");
        
        int a = Integer.parseInt(split[0]);
        int b = Integer.parseInt(split[2]);
        
        
        if (split[1].equals("+")) {
            return a + b;
        }
        
        if (split[1].equals("-")) {
            return a - b;
        }
        
        if (split[1].equals("*")) {
            return a * b;
        }
        
        return answer;
    }
}