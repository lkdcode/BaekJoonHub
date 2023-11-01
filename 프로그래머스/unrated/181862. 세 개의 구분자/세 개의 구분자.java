import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        String[] answer = {"EMPTY"};
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < myStr.length(); i++) {
            String check = String.valueOf(myStr.charAt(i));
            
            if (check.equals("a") || check.equals("b") || check.equals("c")) {
                if (sb.length() != 0) {
                list.add(sb.toString());
                }
                sb = new StringBuilder();
                continue;
            }
            sb.append(check);
        }
        
        if (sb.length() != 0) {
            list.add(sb.toString());
        }
        
        // System.out.println(list);
        
        if (list.size() == 0) return answer;
        
        return list.toArray(String[]::new);
    }
}