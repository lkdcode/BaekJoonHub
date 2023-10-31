import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        List<String> list = new ArrayList<>();
        
        for (int i = 0; i < my_string.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < my_string.length(); j++) {
                sb.append(String.valueOf(my_string.charAt(j)));
            }
            list.add(sb.toString());
        }
        
        Collections.sort(list);
        
        return list.toArray(String[]::new);
    }
}