import java.util.*;

class Solution {
    public String[] solution(String myString) {
        List<String> list = new ArrayList<>();
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < myString.length(); i++) {
            if (myString.charAt(i) == 'x') {
                if (sb.length() != 0) list.add(sb.toString());
                sb = new StringBuilder();
                continue;
            }
            sb.append(String.valueOf(myString.charAt(i)));
        }
        
        if (sb.length() != 0) list.add(sb.toString());
        
        Collections.sort(list);
        // System.out.println(list);
        
        return list.toArray(String[]::new);
    }
}