import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        List<Integer> arrList = Arrays.stream(arr)
            .boxed().collect(Collectors.toList());
        
        List<Integer> deleteList = Arrays.stream(delete_list)
            .boxed().collect(Collectors.toList());
        
        List<Integer> answer = new ArrayList<>();
        
        for (int i = 0; i < arrList.size(); i++) {
            if (deleteList.contains(arrList.get(i))) continue;
            answer.add(arrList.get(i));
        }
        
        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}