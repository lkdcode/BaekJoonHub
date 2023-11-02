import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] arr) {
        List<Integer> list = Arrays.stream(arr)
                                .boxed()
                                .collect(Collectors.toList());
        List<Integer> list2 = new ArrayList<>(list);
        
        int count = 0;
        while (true) {
            
            for (int i = 0; i < list.size(); i++) {
                int number = list.get(i);
                if (number >= 50 && number % 2 == 0) {
                    number /= 2;
                } else if (number < 50 && number % 2 == 1) {
                    number *= 2;
                    number++;
                }
                list.set(i, number);
            }
            
            if (list.equals(list2)) break;
            
            list2 = new ArrayList<>(list);
            count++;
        }
        
        return count;
    }
}