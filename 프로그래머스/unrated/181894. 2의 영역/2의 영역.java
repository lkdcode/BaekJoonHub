import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int startIndex = -1;
        int endIndex = -2;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) {
                if (startIndex == -1) startIndex = i;
                endIndex = i;
            }
        }
        
        List<Integer> list = new ArrayList<>();
                
        for (int i = startIndex; i <= endIndex; i++) {
            list.add(arr[i]);
        }
        
        return list.size() == 0 ? new int[]{-1} : list.stream().mapToInt(Integer::intValue).toArray();    
    }
}