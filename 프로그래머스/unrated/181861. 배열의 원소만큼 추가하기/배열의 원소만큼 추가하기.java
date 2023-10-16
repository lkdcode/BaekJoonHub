import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        
        for (int number : arr) {
            for (int i = 0; i < number; i++) {
                list.add(number);
            }
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}