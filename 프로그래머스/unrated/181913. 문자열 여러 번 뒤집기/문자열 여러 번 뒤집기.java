import java.util.*;

class Solution {
    public String solution(String my_string, int[][] queries) {
        StringBuilder answer = new StringBuilder(my_string);
        
        for (int i = 0; i < queries.length; i++) {
            int s = queries[i][0];
            int e = queries[i][1] + 1;
            
            StringBuilder sb = 
                new StringBuilder(answer.substring(s, e)).reverse();
            
            answer.replace(s, e, sb.toString());
        }
        
        return answer.toString();
    }
}