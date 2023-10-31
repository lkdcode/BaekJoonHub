import java.util.*;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < intStrs.length; i++) {
            String value = intStrs[i].substring(s, s + l);
            int number = Integer.parseInt(value);
            if (number > k) {
                list.add(number);
            }
            
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}