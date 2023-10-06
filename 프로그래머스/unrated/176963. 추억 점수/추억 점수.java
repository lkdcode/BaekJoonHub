import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }
    
        int index = 0;
        for (String[] photos : photo) {
            for (String findName : photos) {
                if (map.containsKey(findName)) { 
                    answer[index] += map.get(findName);
                }
            }
            index++;
        }
        
        return answer;
    }
}