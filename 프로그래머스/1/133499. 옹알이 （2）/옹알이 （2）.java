import java.util.*;

class Solution {
    
    
    public int solution(String[] babbling) {
        int answer = 0;
        String[] speakable = {"aya", "ye", "woo", "ma"};
        
        for (String check : babbling) {            
            boolean[] isSaid = new boolean[4];
            
            next:
            for (int i = 0; i < check.length(); i++) {
                
                for (int j = 0; j < speakable.length; j++) {
                    String say = speakable[j];
                    
                    if (check.startsWith(say) && !isSaid[j]) {
                        isSaid = new boolean[4];
                        isSaid[j] = true;
                        check = check.substring(say.length());
                        i = 0;
                        continue next;
                    }

                }
            }
            // System.out.println(check + " < < < ");
            if (check.equals("")) answer++;
        }
        return answer;
    }
}