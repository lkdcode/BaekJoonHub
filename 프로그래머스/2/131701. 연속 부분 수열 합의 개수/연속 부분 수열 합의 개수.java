import java.util.*;

class Solution {
    public int solution(int[] elements) {
         final List<Integer> list = new ArrayList<>();
        final Set<Integer> set = new HashSet<>();
        for (int number : elements) {
            list.add(number);
            set.add(number);
        }

        for (int number : elements) {
            list.add(number);
        }

        for (int i = 1; i <= elements.length; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum += list.get(j);
            }

            set.add(sum);
            int start = 0;
            for (int j = i; j < elements.length + i; j++) {
                sum -= list.get(start++);
                sum += list.get(j);
                set.add(sum);
            }
        }

        
        return set.size();
    }
}