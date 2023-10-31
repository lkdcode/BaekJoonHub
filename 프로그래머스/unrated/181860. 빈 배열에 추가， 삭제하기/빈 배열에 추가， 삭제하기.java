import java.util.*;

class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i = 0; i < arr.length; i++) {
            if (flag[i]) {
                for (int j = 0; j < arr[i] * 2; j++) {
                    deque.add(arr[i]);
                }
            } else {
                for (int j = 0; j < arr[i]; j++) {
                    deque.pollLast();
                }
            }
        }
        
        int[] answer = new int[deque.size()];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = deque.poll();
        }
        
        return answer;
    }
}