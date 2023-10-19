import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        boolean[] isSkip = new boolean[26];
        
        for (int i = 0; i < skip.length(); i++) {
            char c = skip.charAt(i);
            isSkip[(int) c - 97] = true;
        }
        
        StringBuilder answer = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            int skipIndex = (int) (s.charAt(i) - 97);
            
            int count = 0;
            
            while (true) {
                skipIndex++;
                if (skipIndex > 25) skipIndex -= 26;
                if (!isSkip[skipIndex]) count++;
                if (count == index) break;
            }
            
            // System.out.println(skipIndex + " " + );
            answer.append(String.valueOf((char) (skipIndex + 97)));
        }
        
        return answer.toString();
    }
}