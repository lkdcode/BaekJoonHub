import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        Stack<Integer> stk = new Stack<>();
        
        int index = 0;
        
        while (true) {
            if (index >= arr.length) break;
            
            if (stk.size() == 0) {
                stk.push(arr[index]);
                index++;
            } else if (stk.peek() == arr[index]) {
                stk.pop();
                index++;
            } else if (stk.peek() != arr[index]) {
                stk.push(arr[index]);
                index++;
            }
        }
        
        int size = stk.size();
        answer = new int[size];
        
        for (int i = answer.length - 1; i >= 0; i--) {
            answer[i] = stk.pop();
        }
        
        return size == 0 ? new int[]{-1} : answer;
    }
}