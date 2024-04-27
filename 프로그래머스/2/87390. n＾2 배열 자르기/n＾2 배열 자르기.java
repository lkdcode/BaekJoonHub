import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        final List<Integer> list = new ArrayList<>();

        for (long i = left; i <= right; i++) {

            final int x = (int) (i / n);
            final int y = (int) (i % n);

            list.add(Math.max(x + 1, y + 1));
        }

        return list.stream()
            .mapToInt(i -> i)
            .toArray();
    }
}