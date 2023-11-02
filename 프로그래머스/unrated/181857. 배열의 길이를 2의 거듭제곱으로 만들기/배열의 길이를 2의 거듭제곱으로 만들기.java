import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = Arrays.stream(arr)
                            .boxed()
                            .collect(Collectors.toList());
        
        int length = arr.length;
        
        List<Integer> numberTwoPowerList = new ArrayList<>();
        
        int index = 0;
        while (true) {
            int twoPower = (int) Math.pow(2, index++);
            numberTwoPowerList.add(twoPower);
            if (twoPower == 1024) break;
        }

        int count = 0;
        for (int i = 0; i < numberTwoPowerList.size(); i++) {
            if (numberTwoPowerList.get(i) >= length) {
                count = numberTwoPowerList.get(i) - length;
                break;
            } 
        }
        
        for (int i = 0; i < count; i++) {
            list.add(0);
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}