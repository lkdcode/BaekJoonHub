import java.util.*;

class Solution {
    public String solution(int[] food) {
        String answer = "";
        
        int caseSize = food.length;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 1; i < caseSize; i++) {
            int size = food[i] / 2;
            map.put(i, size);
        }
        
        for (int i = 1; i < caseSize; i++) {
            int size = map.get(i);
            
            for (int j = 0; j < size; j++) {
                answer += i;
            }
        }
        
        answer += 0;
        
        for (int i = caseSize - 1; i > 0; i--) {
            int size = map.get(i);
            
            for (int j = 0; j < size; j++) {
                answer += i;
            }
            
        }
        
        return answer;
    }
}