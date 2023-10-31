import java.util.*;

class Solution {
    public String solution(int[] numLog) {
        StringBuilder answer = new StringBuilder();
        
        for (int i = 1; i < numLog.length; i++) {
            int number = numLog[i - 1];
            if (numLog[i] + 1 == number) {
                answer.append("s");
                continue;
            }
            
            if (numLog[i] - 1 == number) {
                answer.append("w");
                continue;
            }
            
            if (numLog[i] + 10 == number) {
                answer.append("a");
                continue;
            }
            
            if (numLog[i] - 10 == number) {
                answer.append("d");
            }
            
        }
        
        return answer.toString();
    }
}