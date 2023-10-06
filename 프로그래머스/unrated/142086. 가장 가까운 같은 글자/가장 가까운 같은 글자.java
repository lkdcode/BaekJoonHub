import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            String checkString = String.valueOf(s.charAt(i));
            
            if (map.containsKey(checkString)) {
                answer[i] = i - map.get(checkString);
                map.put(checkString, i);
                continue;
            }
            
            map.put(checkString, i);
            answer[i] = -1;
        }
        
        return answer;
    }
}