import java.util.*;

class Solution {
        public String solution(String[] participant, String[] completion) {
            String answer = "";

            Map<String, Integer> map = new HashMap<>();

            for (String s : participant) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
            
            for (String s : completion) {
                map.put(s, map.get(s) - 1);
            }
            
            for (String s : map.keySet()) {
                if (map.get(s) == 1) return s;
            }

            return answer;
        }
}