import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> cards1Queue = new LinkedList<>();
        Queue<String> cards2Queue = new LinkedList<>();
        
        for (String word : cards1) {
            cards1Queue.add(word);
        }
        
        for (String word : cards2) {
            cards2Queue.add(word);
        }
        
        for (String check : goal) {
            if (check.equals(cards1Queue.peek())) {
              cards1Queue.poll();
              continue;  
            } 
            
            if (check.equals(cards2Queue.peek())) {
              cards2Queue.poll();
              continue;  
            }
            
            return "No";
        }
        
        return "Yes";
    }
}