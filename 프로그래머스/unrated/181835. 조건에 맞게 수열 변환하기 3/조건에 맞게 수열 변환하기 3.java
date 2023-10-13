import java.util.*;

class Solution {
    public int[] solution(int[] array, int k) {
        return k % 2 == 1
                ? Arrays.stream(array).map(a -> a * k).toArray()
                : Arrays.stream(array).map(a -> a + k).toArray();
    }
}