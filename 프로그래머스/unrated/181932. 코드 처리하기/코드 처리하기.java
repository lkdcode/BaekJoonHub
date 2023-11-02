import java.util.*;

class Solution {
    public String solution(String code) {
        boolean mode = false;
        
        StringBuilder ret = new StringBuilder();
        
        for (int i = 0; i < code.length(); i++) {
            char check = code.charAt(i);
            
            if (check == '1') {
                mode = !mode;
                continue;
            }
            
            if (!mode) {
                if (i % 2 == 0) ret.append(String.valueOf(check));
            } else {
                if (i % 2 == 1) ret.append(String.valueOf(check));
            }
        }
        
        return ret.length() == 0 ? "EMPTY" : ret.toString();
    }
}