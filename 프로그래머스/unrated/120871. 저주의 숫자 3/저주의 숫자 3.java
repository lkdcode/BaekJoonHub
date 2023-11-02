import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        int index = 1;
        
        for (int i = 1; i <= 100; i++) {
            while (true) {
                if (String.valueOf(index).contains("3")
                   || index % 3 == 0) {
                    index++;
                } else {
                    break;
                }
            }
            map.put(i, index);
            index++;
        }
        
        return map.get(n);
    }
}