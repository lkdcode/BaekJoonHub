import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String my_string, int[] indices) {
        String answer = "";
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < indices.length; i++) {
            list.add(indices[i]);
        }
        
        for (int i = 0; i < my_string.length(); i++) {
            if (list.contains(i)) continue;
            answer += String.valueOf(my_string.charAt(i));
        }
        
        return answer;
    }
}