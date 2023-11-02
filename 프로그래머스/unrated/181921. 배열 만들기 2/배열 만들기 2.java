import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        
        for (int i = l; i <= r; i++) {
            String str = "" + i;
            if (str.matches("^[05]+$")) list.add(i);
        }
        
        return list.size() == 0 ? new int[]{-1} : list.stream().mapToInt(Integer::intValue).toArray();
    }
}