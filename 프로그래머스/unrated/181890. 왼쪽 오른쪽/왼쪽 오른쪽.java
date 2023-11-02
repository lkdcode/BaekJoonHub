import java.util.*;

class Solution {
    public String[] solution(String[] str_list) {
        String[] answer = {};
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        
        for (int i = 0; i < str_list.length; i++) {
            if (str_list[i].equals("l")) {
                return list.toArray(String[]::new);
            }
            
            if (str_list[i].equals("r")) {
                for (int j = i + 1; j < str_list.length; j++) {
                    list2.add(str_list[j]);
                }
                return list2.toArray(String[]::new);
            }
            list.add(str_list[i]);
        }
        
        return answer;
    }
}