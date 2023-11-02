import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
            int number = arr[i];
            if (!list.contains(number)) {
                list.add(number);
            }
            
            if (list.size() == k) break;
        }
        
        while (list.size() < k) {
            list.add(-1);
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}