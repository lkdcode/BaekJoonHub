import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        int[] answer = {};
        
        List<Integer> list = Arrays.stream(numlist)
            .boxed()
            .collect(Collectors.toList());
        
        Collections.sort(list, new CustomComparator(n));
        
        // System.out.println(list);
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public static class CustomComparator implements Comparator<Integer> {
        private final int target;

        public CustomComparator(int target) {
            this.target = target;
        }

        @Override
        public int compare(Integer num1, Integer num2) {
            int num1Result = Math.abs(num1 - target);
            int num2Result = Math.abs(num2 - target);
            if (num1Result == num2Result) {
                return Integer.compare(num2, num1);
            } else {
                return Integer.compare(num1Result, num2Result);
            }
        }
        
    }
}