import java.util.*;

class Solution {
    public int[] solution(int num, int total) {
        
        for (int i = total + num; i >= Integer.MIN_VALUE; i--) {
            List<Integer> list = new ArrayList<>();
            
            int sum = 0;
            int number = i;
            
            for (int j = 0; j < num; j++) {
                sum += number;
                list.add(number--);
            }
            
            if (sum == total) {
                Collections.sort(list);
                return list.stream().mapToInt(Integer::intValue).toArray();
            }            
        }
        
        return null;
    }
}