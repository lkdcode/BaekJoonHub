import java.util.*;

class Solution {
    
    public String solution(int a, int b) {
        Map<String, String> map = new HashMap<>();
        
        String[] week = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        
        Queue<String> weekQueue = new LinkedList<>();
        
        for (String input : week) {
            weekQueue.add(input);
        }
        
        int[] day = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int weekIndex = 0;
        
        for (int i = 1; i <= 12; i++) {
            for (int j = 1; j <= day[i - 1]; j++) {
                map.put(i + "." + j, weekQueue.peek());
                weekQueue.add(weekQueue.poll());
            }
        }
        
        return map.get(a + "." + b);
    }
}