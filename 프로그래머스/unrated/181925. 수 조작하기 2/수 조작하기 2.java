class Solution {
    public String solution(int[] numLog) {
        String answer = "";
        // int number = numLog[0];
        
        for (int i = 1; i < numLog.length; i++) {
            int number = numLog[i - 1];
            if (numLog[i] + 1 == number) {
                answer += "s";
            }
            
            if (numLog[i] - 1 == number) {
                answer += "w";
            }
            
            if (numLog[i] + 10 == number) {
                answer += "a";
            }
            
            if (numLog[i] - 10 == number) {
                answer += "d";
            }
            
        }
        
        return answer;
    }
}